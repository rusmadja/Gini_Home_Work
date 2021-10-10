package com.reouven.app_using_api_in_view.model

import com.squareup.moshi.Json


data class Numbers(
    @Json(name = "numbers")
    var numbers: List<Number>
) {
    /**
     * When you create the [Numbers] Object,
     * We need to sort the [List] of [Number] and to check the compatibility between [Number]s
     */
    init {
        numbers = numbers.sortedBy { it.number }
        setAllNumber()
    }

    /**
     * set flag of all number contained in the [List] of [Number]
     * if existing another [Number] than n1 = -n2 set both of them to true
     */
    private fun setAllNumber() {
        for (i_index in numbers.indices) {
            if (!numbers[i_index].flag)
                for (j_index in numbers.indices){
                    if (j_index != i_index &&
                        numbers[i_index].number == -numbers[j_index].number
                    ) {
                        numbers[i_index].flag = true
                        numbers[j_index].flag = true
                    }
                }
        }
    }

}
