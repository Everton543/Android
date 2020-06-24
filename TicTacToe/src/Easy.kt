import kotlin.random.Random

fun willWIn(playerTargets: ArrayList<Int>):Boolean {
    var won: Boolean = false
    check@ for (bu in 1..7) when (bu) {
        1 -> if ((playerTargets.contains(bu) && playerTargets.contains(bu + 1) && playerTargets.contains(bu + 2))
            || (playerTargets.contains(bu) && playerTargets.contains(bu + 3) && playerTargets.contains(bu + 6))
            || (playerTargets.contains(bu) && playerTargets.contains(bu + 4) && playerTargets.contains(bu + 8))
        ) {
            won = true
            break@check
        }

        2 -> if (playerTargets.contains(bu) && playerTargets.contains(bu + 3) && playerTargets.contains(bu + 6)) {
            won = true
            break@check
        }
        3 -> if ((playerTargets.contains(bu) && playerTargets.contains(bu + 3) && playerTargets.contains(bu + 6))
            || (playerTargets.contains(bu) && playerTargets.contains(bu + 2) && playerTargets.contains(bu + 4))
        ) {
            won = true
            break@check
        }

        4 -> if (playerTargets.contains(bu) && playerTargets.contains(bu + 1) && playerTargets.contains(bu + 2)) {
            won = true
            break@check
        }

        7 -> if (playerTargets.contains(bu) && playerTargets.contains(bu + 1) && playerTargets.contains(bu + 2)) {
            won = true
            break@check
        }
    }
    return won
}


class Easy(private var player1: ArrayList<Int>, private var player2: ArrayList<Int>, var selected:Int = 0){

    fun run() {
        var options = ArrayList<Int>()
        for(bu in  1..9){
            if(!player1.contains(bu) && !player2.contains(bu)){
                options.add(bu)
            }
        }
        options.forEach{
            player1.add(it)
            if (willWIn(player1)){
                selected = it;
                player1.remove(it)
                return
            }
            player1.remove(it)
        }

        if(options.size > 0)
        selected = options[Random(System.nanoTime()).nextInt(options.size)]
    }

}

fun impossible(player1: ArrayList<Int>, player2: ArrayList<Int>,  selected:Int = 0):Int{
    var player1 = player1
    var player2 = player2
    var selected = selected

    var options = ArrayList<Int>()
    when(player1.size){
        1-> if(player1[0] == 5){
            options.add(1)
            options.add(3)
            options.add(7)
            options.add(9)
        }else{
            options.add(5)
        }
        2-> if(player1.contains(5)) {
            for (bu in 1..9) {
                if (!player1.contains(bu) && !player2.contains(bu)) {
                    options.add(bu)
                }

                options.forEach {
                    player1.add(it)
                    if (willWIn(player1)) {
                        selected = it;
                        player1.remove(it)
                        return selected
                    }
                    player1.remove(it)
                }
                options.clear()
                if(!player1.contains(1) && !player2.contains(1)) {
                    options.add(1)
                }

                if(!player1.contains(3) && !player2.contains(3)) {
                    options.add(3)
                }
                if(!player1.contains(7) && !player2.contains(7)) {
                    options.add(7)
                }

                if(!player1.contains(9) && !player2.contains(9)) {
                    options.add(9)
                }

            }
        }
        else{
            for (bu in 1..9) {
                if (!player1.contains(bu) && !player2.contains(bu)) {
                    options.add(bu)
                }

                options.forEach {
                    player1.add(it)
                    if (willWIn(player1)) {
                        selected = it;
                        player1.remove(it)
                        return selected
                    }
                    player1.remove(it)
                }
                options.clear()
                if (!player1.contains(2) && !player2.contains(2)) {
                    options.add(2)
                }

                if (!player1.contains(6) && !player2.contains(6)) {
                    options.add(6)
                }
                if (!player1.contains(4) && !player2.contains(4)) {
                    options.add(4)
                }

                if (!player1.contains(8) && !player2.contains(8)) {
                    options.add(8)
                }
            }
        }
    }

    if(options.size == 0) {
        for (bu in 1..9) {
            if (!player1.contains(bu) && !player2.contains(bu)) {
                options.add(bu)
            }

        }

        options.forEach {
            player2.add(it)
            if (willWIn(player2)) {
                selected = it;
                player2.remove(it)
                return selected
            }
            player2.remove(it)
        }

        options.forEach {
            player1.add(it)
            if (willWIn(player1)) {
                selected = it;
                player1.remove(it)
                return selected
            }
            player1.remove(it)
        }
    }
    if(options.size > 0)
        selected = options[Random(System.nanoTime()).nextInt(options.size)]

    return selected
}