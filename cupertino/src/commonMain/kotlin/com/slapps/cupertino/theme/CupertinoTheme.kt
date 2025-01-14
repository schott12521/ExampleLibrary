/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */




package com.slapps.cupertino.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalHapticFeedback
import com.slapps.cupertino.LocalContentColor
import com.slapps.cupertino.LocalTextStyle
import com.slapps.cupertino.ExperimentalCupertinoApi
import com.slapps.cupertino.InternalCupertinoApi
import com.slapps.cupertino.SystemBarAppearance
import com.slapps.cupertino.rememberCupertinoHapticFeedback
import com.slapps.cupertino.rememberCupertinoIndication

@OptIn(InternalCupertinoApi::class, ExperimentalCupertinoApi::class)
@Composable
fun CupertinoTheme(
    colorScheme: ColorScheme =
        if (isSystemInDarkTheme()) {
            darkColorScheme()
        } else {
            lightColorScheme()
        },
    shapes: Shapes = Shapes(),
    typography: Typography = Typography(),
    content: @Composable () -> Unit,
) {
    SystemBarAppearance(colorScheme.isDark)
    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalTextStyle provides typography.body,
        LocalContentColor provides colorScheme.label,
        LocalIndication provides rememberCupertinoIndication(),
        LocalHapticFeedback provides rememberCupertinoHapticFeedback(),
        content = content,
    )
}

internal val BrightSeparatorColor
    get() = CupertinoColors.Gray.copy(alpha = .5f)
