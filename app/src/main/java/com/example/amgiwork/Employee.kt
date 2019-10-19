package com.example.amgiwork

data class Employee(
    var name: String = "",
    var eligibility: Int = 99,
    var quota: Int = 99,
    var cap: Pair<Int, Int> = when (eligibility) {
        Consts.ELIGIBILITY_ELIGIBLE_ID -> Pair(
            Consts.ELIGIBILITY_ELIGIBLE_QUOTA,
            Consts.ELIGIBILITY_ELIGIBLE_PERWEEK
        )
        Consts.ELIGIBILITY_SEMI_ID -> Pair(
            Consts.ELIGIBILITY_SEMI_QUOTA,
            Consts.ELIGIBILITY_SEMI_PERWEEK
        )
        Consts.ELIGIBILITY_NON_ID -> Pair(
            Consts.ELIGIBILITY_NON_QUOTA,
            Consts.ELIGIBILITY_NON_PERWEEK
        )
        else -> Pair(1812, 1995)
    },
    var photo: Int = 99
)

