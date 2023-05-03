package com.example.a7minworkout

object AbsConstants {
    fun defaultExerciceList() : ArrayList<ExerciseModel>{
        val exerciseList=ArrayList<ExerciseModel>()


        val jumpingJacks =
            ExerciseModel(1, "Hanging Knee Raise", R.drawable.exercise1, false, false)
        exerciseList.add(jumpingJacks)

        val wallSit = ExerciseModel(2, "V-UP", R.drawable.exercise2, false, false)
        exerciseList.add(wallSit)

        val pushUp = ExerciseModel(3, "Sit-Up Reach", R.drawable.exercise3, false, false)
        exerciseList.add(pushUp)

        val abdominalCrunch =
            ExerciseModel(4, "STANDING CABLE CRUNCH", R.drawable.exercise4, false, false)
        exerciseList.add(abdominalCrunch)

        val stepUpOnChair =
            ExerciseModel(
                5,
                "Reverse Crunch",
                R.drawable.exercise5,
                false,
                false
            )
        exerciseList.add(stepUpOnChair)

        val squat = ExerciseModel(6, "lank With Hip Extension", R.drawable.exercise6, false, false)
        exerciseList.add(squat)

        val tricepDipOnChair =
            ExerciseModel(
                7,
                "OBLIQUE FLOOR CRUNCHES",
                R.drawable.exercise7,
                false,
                false
            )
        exerciseList.add(tricepDipOnChair)

        val plank = ExerciseModel(8, "LegRaise", R.drawable.exercise8, false, false)
        exerciseList.add(plank)

        val highKneesRunningInPlace =
            ExerciseModel(
                9, "Indian Push-Ups",
                R.drawable.exercise9,
                false,
                false
            )
        exerciseList.add(highKneesRunningInPlace)

        val lunges = ExerciseModel(10, "Indian Push-Ups", R.drawable.exercise10, false, false)
        exerciseList.add(lunges)

        val pushupAndRotation =
            ExerciseModel(
                11,
                "Boat Pose",
                R.drawable.exercise11,
                false,
                false
            )
        exerciseList.add(pushupAndRotation)

        val sidePlank = ExerciseModel(12, "Bicycle Crunches", R.drawable.exercise12, false, false)
        exerciseList.add(sidePlank)






        return exerciseList
    }
}