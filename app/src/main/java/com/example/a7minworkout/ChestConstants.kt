package com.example.a7minworkout

object ChestConstants {fun defaultExerciceList() : ArrayList<ExerciseModel>{
    val exerciseList=ArrayList<ExerciseModel>()


    val jumpingJacks =
        ExerciseModel(1, "BENCH PRESS", R.drawable.benchpress, false, false)
    exerciseList.add(jumpingJacks)

    val wallSit = ExerciseModel(2, "CABLE CROSSOVER", R.drawable.cablecrossover, false, false)
    exerciseList.add(wallSit)

    val pushUp = ExerciseModel(3, "CABLE UPPER CHEST CROSSOVERS (UPPER CHEST)", R.drawable.cableuperchestcrossover, false, false)
    exerciseList.add(pushUp)

    val abdominalCrunch =
        ExerciseModel(4, "DUMBBELL BENCH PRESS", R.drawable.dumbbellbenchpress, false, false)
    exerciseList.add(abdominalCrunch)

    val stepUpOnChair =
        ExerciseModel(
            5,
            "DUMBBELL FLY",
            R.drawable.dumbbelfly,
            false,
            false
        )
    exerciseList.add(stepUpOnChair)

    val squat = ExerciseModel(6, "DUMBBELL PULLOVER", R.drawable.dumbbellpullover, false, false)
    exerciseList.add(squat)

    val tricepDipOnChair =
        ExerciseModel(
            7,
            "HIGH CABLE CROSSOVER",
            R.drawable.highcablecrossover,
            false,
            false
        )
    exerciseList.add(tricepDipOnChair)

    val plank = ExerciseModel(8, "INCLINE BARBELL BENCH PRESS", R.drawable.inclinebarbellbenchpress, false, false)
    exerciseList.add(plank)

    val highKneesRunningInPlace =
        ExerciseModel(
            9, "LOW CABLE CROSSOVER",
            R.drawable.lowcablecrossover,
            false,
            false
        )
    exerciseList.add(highKneesRunningInPlace)

    val lunges = ExerciseModel(10, "ONE ARM CABLE CHEST PRESS", R.drawable.onearmcablechestpress, false, false)
    exerciseList.add(lunges)

    val pushupAndRotation =
        ExerciseModel(
            11,
            "PEC DECK FLY",
            R.drawable.pecdeckfly,
            false,
            false
        )
    exerciseList.add(pushupAndRotation)

    val sidePlank = ExerciseModel(12, "SINGLE-ARM CABLE CROSSOVER", R.drawable.signlearmcablecrossover, false, false)
    exerciseList.add(sidePlank)






    return exerciseList
}

}