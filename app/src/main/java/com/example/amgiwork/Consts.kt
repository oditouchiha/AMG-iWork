package com.example.amgiwork

object Consts {

    private const val ELIGIBILITY_ELIGIBLE_ID = 1
    private const val ELIGIBILITY_ELIGIBLE_TEXT = "Eligible"

    private val ELIGIBILITY_ELIGIBLE = mapOf(
        "ID" to ELIGIBILITY_ELIGIBLE_ID,
        "TEXT" to ELIGIBILITY_ELIGIBLE_TEXT
    )

    private const val ELIGIBILITY_SEMI_ID = 2
    private const val ELIGIBILITY_SEMI_TEXT = "Semi-Eligible"

    private val ELIGIBILITY_SEMI = mapOf(
        "ID" to ELIGIBILITY_SEMI_ID,
        "TEXT" to ELIGIBILITY_SEMI_TEXT
    )

    private const val ELIGIBILITY_NON_ID = 3
    private const val ELIGIBILITY_NON_TEXT = "Non-Eligible"

    private val ELIGIBILITY_NON = mapOf(
        "ID" to ELIGIBILITY_NON_ID,
        "TEXT" to ELIGIBILITY_NON_TEXT
    )

    val ELIGIBILITY = mapOf(
        ELIGIBILITY_ELIGIBLE_ID to ELIGIBILITY_ELIGIBLE,
        ELIGIBILITY_SEMI_ID to ELIGIBILITY_SEMI,
        ELIGIBILITY_NON_ID to ELIGIBILITY_NON
    )
}
