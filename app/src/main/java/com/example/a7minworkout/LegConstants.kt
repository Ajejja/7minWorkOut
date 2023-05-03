package com.example.a7minworkout

object LegConstants {
    fun defaultExerciceList() : ArrayList<ExerciseModel>{
        val exerciseList=ArrayList<ExerciseModel>()


        val jumpingJacks =
            ExerciseModel(1, "BARBELL HACK SQUATS", R.drawable.barbellhacksquat, false, false)
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(2, "BODY WEIGHT SUMO SQUAT", R.drawable.bodyweightsumosquat, false, false)
        exerciseList.add(wallSit)

        val pushUp = ExerciseModel(3, "DEAD LIFT", R.drawable.deadlift, false, false)
        exerciseList.add(pushUp)

        val abdominalCrunch =
            ExerciseModel(4, "HAWAIIAN SQUAT", R.drawable.hawaiinsquat, false, false)
        exerciseList.add(abdominalCrunch)

        val stepUpOnChair =
            ExerciseModel(
                5,
                "HACK SQUATS MACHINE",
                R.drawable.hacksquatsmachine,
                false,
                false
            )
        exerciseList.add(stepUpOnChair)

        val squat = ExerciseModel(6, "LEG CURL", R.drawable.legcurl, false, false)
        exerciseList.add(squat)

        val tricepDipOnChair =
            ExerciseModel(
                7,
                "ROMANIAN DEAD LIFT",
                R.drawable.romaniandeaflift,
                false,
                false
            )
        exerciseList.add(tricepDipOnChair)

        val plank = ExerciseModel(8, "LEG EXTENSION", R.drawable.legextension, false, false)
        exerciseList.add(plank)

        val highKneesRunningInPlace =
            ExerciseModel(
                9, "LEG PRESS",
                R.drawable.legpress,
                false,
                false
            )
        exerciseList.add(highKneesRunningInPlace)

        val lunges = ExerciseModel(10, "PLIE DUMBBELL SQUAT", R.drawable.pliedumbbellsquat, false, false)
        exerciseList.add(lunges)

        val pushupAndRotation =
            ExerciseModel(
                11,
                "SEATED LEG CURL",
                R.drawable.seatedlegcurl,
                false,
                false
            )
        exerciseList.add(pushupAndRotation)

        val sidePlank = ExerciseModel(12, "SQUAT", R.drawable.squat, false, false)
        exerciseList.add(sidePlank)






        return exerciseList
    }

}