
class CheckWinner(private var player1: ArrayList<Int>, private var player2: ArrayList<Int>): Thread() {
    var winner = -1
    override fun run() {
        super.run()

        checking@ for (bu in 1..7) {
            when (bu) {
                1 -> if ((player1.contains(bu) && player1.contains(bu + 1) && player1.contains(bu + 2))
                    || (player1.contains(bu) && player1.contains(bu + 3) && player1.contains(bu + 6))
                    || (player1.contains(bu) && player1.contains(bu + 4) && player1.contains(bu + 8))
                ) {
                    winner = 1
                    break@checking
                } else if ((player2.contains(bu) && player2.contains(bu + 1) && player2.contains(bu + 2))
                    || (player2.contains(bu) && player2.contains(bu + 3) && player2.contains(bu + 6))
                    || (player2.contains(bu) && player2.contains(bu + 4) && player2.contains(bu + 8))
                ) {
                    winner = 2
                    break@checking
                }

                2 -> if (player1.contains(bu) && player1.contains(bu + 3) && player1.contains(bu + 6)) {
                    winner = 1
                    break@checking
                } else if (player2.contains(bu) && player2.contains(bu + 3) && player2.contains(bu + 6)) {
                    winner = 2
                    break@checking
                }

                3 -> if ((player1.contains(bu) && player1.contains(bu + 3) && player1.contains(bu + 6))
                    || (player1.contains(bu) && player1.contains(bu + 2) && player1.contains(bu + 4))
                ) {
                    winner = 1
                    break@checking
                } else if ((player2.contains(bu) && player2.contains(bu + 3) && player2.contains(bu + 6))
                    || (player2.contains(bu) && player2.contains(bu + 2) && player2.contains(bu + 4))
                ) {
                    winner = 2
                    break@checking
                }

                4 -> if (player1.contains(bu) && player1.contains(bu + 1) && player1.contains(bu + 2)) {
                    winner = 1
                    break@checking
                } else if (player2.contains(bu) && player2.contains(bu + 1) && player2.contains(bu + 2)) {
                    winner = 2
                    break@checking
                }

                7 -> if (player1.contains(bu) && player1.contains(bu + 1) && player1.contains(bu + 2)) {
                    winner = 1
                    break@checking
                } else if (player2.contains(bu) && player2.contains(bu + 1) && player2.contains(bu + 2)) {
                    winner = 2
                    break@checking
                }
            }

        }
    }
}

fun impossibleMode(){
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var select:Int = 0
    println("Choose a house from 1 to 9; Type 99 to giveUP; 100 to restart")
    print(">> ")
    select = readLine()!!.toInt()
    player1.add(select)
    var impossible = impossible(player1,player2)
    player2.add(impossible)

    while(select < 90){
        println("You have: ")
        player1.forEach{
            print("$it ")
        }
        print("\n")
        println("Computer have: ")
        player2.forEach{
            print("$it ")
        }
        print("\n")
        println("Choose a house from 1 to 9; Type 99 to giveUP")
        print(">> ")
        select = readLine()!!.toInt()
        player1.add(select)
        var impossible = impossible(player1,player2)
        player2.add(impossible)
    }

    initiateGame()

}

fun easyMode(){
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var select:Int = 0
    println("Choose a house from 1 to 9; Type 99 to giveUP; 100 to restart")
    print(">> ")
    select = readLine()!!.toInt()
    player1.add(select)
    var easy = Easy(player1,player2)
    easy.run()
    player2.add(easy.selected)

    while(select < 90){
        println("You have: ")
        player1.forEach{
            print("$it ")
        }
        print("\n")
        println("Computer have: ")
        player2.forEach{
            print("$it ")
        }
        print("\n")
        println("Choose a house from 1 to 9; Type 99 to giveUP")
        print(">> ")
        select = readLine()!!.toInt()
        player1.add(select)
        var easy = Easy(player1,player2)
        easy.run()
        player2.add(easy.selected)
    }

    initiateGame()

}

fun initiateGame(){
    println("Play ticTacToe against machine select difficulty: 1 to easy; 2 to Impossible")
    print(">> ")
    val option:String = readLine()!!.toString()
    when(option){
        "1" -> easyMode()
        "2" -> impossibleMode()
    }
}

fun main() {
    initiateGame()
}