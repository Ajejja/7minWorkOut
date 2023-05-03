package com.example.a7minworkout

object BicepsConstants {fun defaultExerciceList() : ArrayList<ExerciseModel>{
    val exerciseList=ArrayList<ExerciseModel>()


    val jumpingJacks =
        ExerciseModel(1, "BARBELL CURL", R.drawable.barbellcurl, false, false)
    exerciseList.add(jumpingJacks)

    val wallSit = ExerciseModel(2, "CONCENTRATION CURL", R.drawable.concentrationcurl, false, false)
    exerciseList.add(wallSit)

    val pushUp = ExerciseModel(3, "DOUBLE ARM DUMBBELL CURL", R.drawable.doublearmdumbbellcurl, false, false)
    exerciseList.add(pushUp)

    val abdominalCrunch =
        ExerciseModel(4, "DUMBBELL CURL", R.drawable.dumbbellcurl, false, false)
    exerciseList.add(abdominalCrunch)

    val stepUpOnChair =
        ExerciseModel(
            5,
            "DUMBBELL PREACHER CURL",
            R.drawable.dumbbellpreachercurl,
            false,
            false
        )
    exerciseList.add(stepUpOnChair)

    val squat = ExerciseModel(6, "DUMBBELL REVERSE CURL", R.drawable.dumbbelreversecurl, false, false)
    exerciseList.add(squat)

    val tricepDipOnChair =
        ExerciseModel(
            7,
            "EZ BAR PREACHER CURL",
            R.drawable.ezbarpreadchercurl,
            false,
            false
        )
    exerciseList.add(tricepDipOnChair)

    val plank = ExerciseModel(8, "LEVER PREACHER CURL", R.drawable.leverpreachercurl, false, false)
    exerciseList.add(plank)

    val highKneesRunningInPlace =
        ExerciseModel(
            9, "HIGH CABLE SINGLE ARM BICEP CURL",
            R.drawable.highcablesignlearmbicepcurl,
            false,
            false
        )
    exerciseList.add(highKneesRunningInPlace)

    val lunges = ExerciseModel(10, "HAMMER CURL", R.drawable.hammercurl, false, false)
    exerciseList.add(lunges)

    val pushupAndRotation =
        ExerciseModel(
            11,
            "ONE ARM CABLE CURL",
            R.drawable.onearmcablecurl,
            false,
            false
        )
    exerciseList.add(pushupAndRotation)

    val sidePlank = ExerciseModel(12, "SEATED INCLINE DUMBBELL CURL", R.drawable.seatedinclinedumbbellcurl, false, false)
    exerciseList.add(sidePlank)






    return exerciseList
}

}