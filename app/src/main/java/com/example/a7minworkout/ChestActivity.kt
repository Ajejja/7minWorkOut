package com.example.a7minworkout

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minworkout.databinding.ActivityChestBinding
import com.example.a7minworkout.databinding.ActivityTricepsBinding
import com.example.a7minworkout.databinding.DialogCostumBackBinding
import java.lang.Exception
import java.util.Locale

class ChestActivity : AppCompatActivity() ,TextToSpeech.OnInitListener{
    private var binding: ActivityChestBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var ExRestTimer: CountDownTimer? = null
    private var ExRestProgress = 0
    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1
    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    private var exerciseAdapter: ExerciseStatusAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChestBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.chesttoolbarExercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }

        binding?.chesttoolbarExercise?.setNavigationOnClickListener {
            customDialogForBackButton()
        }


        setupRestView()
        setupExerciseStatusRecyclerView()
        exerciseList = ChestConstants.defaultExerciceList()
        tts = TextToSpeech(this, this)

    }


    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        val dialogBinding = DialogCostumBackBinding.inflate(layoutInflater)

        customDialog.setContentView(dialogBinding.root)

        customDialog.setCanceledOnTouchOutside(false)
        dialogBinding.yesLeaveTheExercise.setOnClickListener {

            this@ChestActivity.finish()
            customDialog.dismiss() // Dialog will be dismissed
        }
        dialogBinding.noStayInTheExercise.setOnClickListener {
            customDialog.dismiss()
        }
        //Start the dialog and display it on screen.
        customDialog.show()
    }
    // END


    private fun setupExerciseStatusRecyclerView() {
        binding?.rvExerciseStatus?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        exerciseAdapter = ExerciseStatusAdapter(exerciseList!!)
        binding?.rvExerciseStatus?.adapter = exerciseAdapter
    }

    private fun setupRestView() {
        try {
            val soundURI = Uri.parse("android.resource://com.example.a7minworkout/" + R.raw.music)
            player = MediaPlayer.create(applicationContext, soundURI)
            player?.isLooping = false

            // Start playback
            player?.start()

            // Delay volume decrease by 3.2 seconds (5.2 - 2.0)
            Handler().postDelayed({
                // Calculate the position of the audio file at the 2-second mark
                val duration = player?.duration ?: 0
                val position = duration - 2000

                // Decrease the volume gradually over 2 seconds
                val fadeDuration = 2000 // Fade duration in milliseconds
                val fadeStart = position
                val fadeEnd = duration
                val fadeRange = fadeEnd - fadeStart
                val step = fadeRange / 10

                for (time in fadeStart until fadeEnd step step) {
                    val volume = 1.0f - ((time - fadeStart).toFloat() / fadeRange)
                    player?.setVolume(volume, volume)
                    Thread.sleep(step.toLong())
                }

                // Stop and release the MediaPlayer
                player?.stop()
                player?.release()

            }, 3100)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding?.let {
            it.flRestView.visibility = View.VISIBLE
            it.tvTitle.visibility = View.VISIBLE
            it.tvExerciseName.visibility = View.INVISIBLE
            it.flProgressBarEx.visibility = View.INVISIBLE
            it.ivImage.visibility = View.INVISIBLE
            it.tvUpComingLabel.visibility = View.VISIBLE
            it.tvUpComingExerciseName.visibility = View.VISIBLE
        }

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        exerciseList = exerciseList ?: ChestConstants.defaultExerciceList()

        currentExercisePosition = currentExercisePosition.takeIf { it < exerciseList?.size ?: 0 } ?: 0

        speakOut("Now let's take a 10 seconds break")

        binding?.tvUpComingExerciseName?.text =
            exerciseList!![currentExercisePosition + 1].getName()

        setProgressBar()
    }


    private fun setupExerciseView() {
        binding?.flRestView?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.flProgressBarEx?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE
        binding?.tvUpComingLabel?.visibility = View.INVISIBLE
        binding?.tvUpComingExerciseName?.visibility = View.INVISIBLE
        if (ExRestTimer != null) {
            ExRestTimer?.cancel()
            ExRestProgress = 0
        }
        speakOut(exerciseList!![currentExercisePosition].getName())
        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text = exerciseList!![currentExercisePosition].getName()
        setExProgressBar()
    }

    private fun setProgressBar() {
        binding?.progressBar?.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                binding?.progressBar?.progress = 10 - restProgress
                binding?.tvTimer?.text = (10 - restProgress).toString()
                if (restProgress == 7) {
                    speakOut(" 3")

                }
                if (restProgress == 8) {
                    speakOut(" 2")

                }
                if (restProgress == 9) {
                    speakOut(" 1")

                }

            }

            override fun onFinish() {
                currentExercisePosition++
                exerciseList!![currentExercisePosition].setIsSelected(true)
                exerciseAdapter?.updateItems(exerciseList!!)
                setupExerciseView()
            }

        }.start()
    }

    private fun setExProgressBar() {
        binding?.progressBarEx?.progress = ExRestProgress
        ExRestTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                ExRestProgress++
                binding?.progressBarEx?.progress = 30 - ExRestProgress
                binding?.tvTimerEx?.text = (30 - ExRestProgress).toString()
                if (ExRestProgress == 10) {
                    speakOut(" 20 seconds")
                }
                if (ExRestProgress == 25) {
                    speakOut(" 5")
                }
                if (ExRestProgress == 26) {
                    speakOut(" 4")
                }
                if (ExRestProgress == 27) {
                    speakOut(" 3")
                }
                if (ExRestProgress == 28) {
                    speakOut(" 2")
                }
                if (ExRestProgress == 29) {
                    speakOut(" 1 ")
                }
                if (ExRestProgress == 20) {
                    speakOut("the last 10 seconds")
                }

            }

            override fun onFinish() {


                if (currentExercisePosition < exerciseList?.size!! - 1) {
                    exerciseList!![currentExercisePosition].setIsSelected(false)
                    exerciseList!![currentExercisePosition].setIsCompleted(true)
                    exerciseAdapter?.updateItems(exerciseList!!)
                    setupRestView()
                } else {
                    Toast.makeText(
                        this@ChestActivity,
                        "Congratulations ! You have completed the 7 minutes workout.",
                        Toast.LENGTH_SHORT
                    ).show()
                    speakOut("Congratulations ! You have completed the 7 minutes workout.")
                    finish()
                    val intent = Intent(this@ChestActivity, FinalActivity::class.java)
                    startActivity(intent)
                }
            }

        }.start()
    }

    public override fun onDestroy() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }

        // Shutting down the Text to Speech feature when activity is destroyed
        // START
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        // END


        //  When the activity is destroyed if the media player instance is not null then stop it.)
        // START
        if (player != null) {
            player!!.stop()
        }
        // END
        super.onDestroy()
        binding = null
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.UK)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Initialization Failed!")
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }

    private fun speakOut(text: String) {
        tts?.let {
            if (it.isSpeaking) {
                it.stop()
            }
            it.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        }
    }
}
