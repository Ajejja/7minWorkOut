package com.example.a7minworkout

object TricepsConstants {fun defaultExerciceList() : ArrayList<ExerciseModel>{
    val exerciseList=ArrayList<ExerciseModel>()


    val jumpingJacks =
        ExerciseModel(1, "BENCH DIPS", R.drawable.benchdips, false, false)
    exerciseList.add(jumpingJacks)

    val wallSit = ExerciseModel(2, "CABLE ROPE OVERHEAD TRICEPS EXTENSION", R.drawable.cableropeoverheadtricepsextension, false, false)
    exerciseList.add(wallSit)

    val pushUp = ExerciseModel(3, "DUMBBELL KICKBACK", R.drawable.dumbbellkickback, false, false)
    exerciseList.add(pushUp)

    val abdominalCrunch =
        ExerciseModel(4, "DUMBBELL SEATED FRONT AND BACK TATE PRESS", R.drawable.dumbbellsteatedfrontandbacktatepress, false, false)
    exerciseList.add(abdominalCrunch)

    val stepUpOnChair =
        ExerciseModel(
            5,
            "LEVER TRICEPS DIP",
            R.drawable.levertricepsdip,
            false,
            false
        )
    exerciseList.add(stepUpOnChair)

    val squat = ExerciseModel(6, "LYING BARBELL TRICEPS EXTENSION", R.drawable.lyingbarbelltricepsextension, false, false)
    exerciseList.add(squat)

    val tricepDipOnChair =
        ExerciseModel(
            7,
            "NARROW GRIP WALL PUSH-UP",
            R.drawable.narrowgripwallpushup,
            false,
            false
        )
    exerciseList.add(tricepDipOnChair)

    val plank = ExerciseModel(8, "ONE ARM LYING TRICEPS EXTENSION", R.drawable.onearmlyingtricepsextension, false, false)
    exerciseList.add(plank)

    val highKneesRunningInPlace =
        ExerciseModel(
            9, "PUSH-DOWN",
            R.drawable.pushdown,
            false,
            false
        )
    exerciseList.add(highKneesRunningInPlace)

    val lunges = ExerciseModel(10, "ONE ARM TRICEPS PUSH-DOWN", R.drawable.onearmtricepspushdown, false, false)
    exerciseList.add(lunges)

    val pushupAndRotation =
        ExerciseModel(
            11,
            "TRICEPS DIPS ON FLOOR",
            R.drawable.tricepsdipsonfloor,
            false,
            false
        )
    exerciseList.add(pushupAndRotation)

    val sidePlank = ExerciseModel(12, "TRICEPS DIPS", R.drawable.tricepsdips, false, false)
    exerciseList.add(sidePlank)






    return exerciseList
}

}