package leetcode


fun main() {
    println("${Solution().numberOfMatches(14)}")

}

class Solution {
    fun numberOfMatches(n: Int): Int {
        return ans(n)
    }

    private fun ans(advanced: Int, matchPlayed: Int = 0): Int {
        if (advanced == 1)
            return matchPlayed

        if (advanced % 2 == 0) {
            val _matchPlayed = matchPlayed + advanced / 2
            val _advanced = advanced / 2
            return ans(_advanced, _matchPlayed)
        } else {
            val _matchPlayed = matchPlayed + advanced / 2
            val _advanced = advanced / 2 + 1
            return ans(_advanced, _matchPlayed)
        }
    }
}
/*
class Solution {
    fun numberOfMatches(n: Int): Int {
        var matchPlayed = 0
        var advanced = n
        while (advanced != 1) {
            if (advanced % 2 == 0) {
                matchPlayed += advanced / 2
                advanced /= 2
            } else {
                matchPlayed += advanced / 2
                advanced = advanced / 2 + 1
            }
        }
        return matchPlayed
    }
}
 */