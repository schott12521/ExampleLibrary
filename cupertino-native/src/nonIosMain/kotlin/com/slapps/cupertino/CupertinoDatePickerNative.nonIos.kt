

package com.slapps.cupertino

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.slapps.cupertino.CupertinoDatePicker
import com.slapps.cupertino.CupertinoDatePickerState
import com.slapps.cupertino.DatePickerStyle
import com.slapps.cupertino.ExperimentalCupertinoApi

@Composable
@ExperimentalCupertinoApi
actual fun CupertinoDatePickerNative(
    state: CupertinoDatePickerState,
    modifier: Modifier,
    style: DatePickerStyle,
    containerColor: Color,
) = CupertinoDatePicker(
    state = state,
    modifier = modifier,
    style = style,
    containerColor = containerColor,
)