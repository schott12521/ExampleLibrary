

package com.slapps.cupertino.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.slapps.cupertino.InternalCupertinoApi

@Immutable
class Typography(
    val largeTitle : TextStyle = TextStyle(
        fontSize = 34.sp,
        lineHeight = 41.sp
    ),
    val title1 : TextStyle= TextStyle(
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    val title2 : TextStyle = TextStyle(
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    val title3 : TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 25.sp
    ),
    val headline : TextStyle = TextStyle(
        fontSize = 17.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.SemiBold
    ),
    val body : TextStyle = TextStyle(
        fontSize = 17.sp,
        lineHeight = 22.sp
    ),
    val callout : TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 21.sp
    ),
    val subhead : TextStyle = TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    val footnote : TextStyle = TextStyle(
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    val caption1 : TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    val caption2 : TextStyle = TextStyle(
        fontSize = 11.sp,
        lineHeight = 13.sp
    ),
) {

    fun copy(
        largeTitle : TextStyle = this.largeTitle,
        title1 : TextStyle = this.title1,
        title2 : TextStyle = this.title2,
        title3 : TextStyle = this.title3,
        headline : TextStyle = this.headline,
        body : TextStyle = this.body,
        callout : TextStyle = this.callout,
        subhead : TextStyle = this.subhead,
        footnote : TextStyle = this.footnote,
        caption1 : TextStyle = this.caption1,
        caption2 : TextStyle = this.caption2,
    ) = Typography(
        largeTitle = largeTitle,
        title1 = title1,
        title2 = title2,
        title3 = title3,
        headline = headline,
        body = body,
        callout = callout,
        subhead = subhead,
        footnote = footnote,
        caption1 = caption1,
        caption2 = caption2
    )
}

@InternalCupertinoApi
val LocalTypography = staticCompositionLocalOf { Typography() }
