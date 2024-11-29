import adaptive.AdaptiveWidgetsScreen
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.materialkolor.dynamicColorScheme
import cupertino.CupertinoWidgetsScreen
import icons.IconsScreen
import com.slapps.cupertino.adaptive.AdaptiveTheme
import com.slapps.cupertino.adaptive.CupertinoThemeSpec
import com.slapps.cupertino.adaptive.ExperimentalAdaptiveApi
import com.slapps.cupertino.adaptive.MaterialThemeSpec
import com.slapps.cupertino.adaptive.Shapes
import com.slapps.cupertino.adaptive.Theme
import com.slapps.cupertino.decompose.cupertinoPredictiveBackAnimation
import com.slapps.cupertino.theme.darkColorScheme
import com.slapps.cupertino.theme.lightColorScheme
import sections.SectionsScreen


expect val IsIos: Boolean

@OptIn(ExperimentalDecomposeApi::class, ExperimentalAdaptiveApi::class)
@Composable
fun App(rootComponent: RootComponent) {

    val theme by derivedStateOf {
        if (rootComponent.isMaterial.value)
            Theme.Material3 else Theme.Cupertino
    }

    val (lightAccent, darkAccent) = rootComponent.accentColor.value

    val isDark by rootComponent.isDark

    val direction = LocalLayoutDirection.current

    val directionState by remember {
        derivedStateOf {
            if (rootComponent.isInvertLayoutDirection.value) {
                if (direction == LayoutDirection.Rtl)
                    LayoutDirection.Ltr else
                    LayoutDirection.Rtl
            } else {
                direction
            }
        }
    }

    ActualPredictiveBackGestureOverlay(
        modifier = Modifier.fillMaxSize(),
        backDispatcher = rootComponent.backDispatcher
    ) {
        Children(
            stack = rootComponent.stack,
            modifier = Modifier.fillMaxSize(),
//            onBack = rootComponent::onBack,
            animation = cupertinoPredictiveBackAnimation(
                backHandler = rootComponent.backHandler,
                onBack = rootComponent::onBack,
            ),
        ) { child ->
            CompositionLocalProvider(
                LocalLayoutDirection provides directionState
            ) {

                GeneratedAdaptiveTheme(
                    target = theme,
                    primaryColor = if (isDark)
                        lightAccent else darkAccent,
                    useDarkTheme = isDark
                ) {

                    when (val c = child.instance) {
                        is RootComponent.Child.Cupertino -> CupertinoWidgetsScreen(c.component)
                        is RootComponent.Child.Adaptive -> AdaptiveWidgetsScreen(c.component)
                        is RootComponent.Child.Icons -> IconsScreen(c.component)
                        is RootComponent.Child.Sections -> SectionsScreen(c.component)
                    }
                }
            }
        }
    }
}

@ExperimentalAdaptiveApi
@Composable
fun GeneratedAdaptiveTheme(
    target: Theme,
    primaryColor: Color,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    shapes: com.slapps.cupertino.adaptive.Shapes = com.slapps.cupertino.adaptive.Shapes(),
    content: @Composable () -> Unit
) {
    AdaptiveTheme(
        target = target,
        material = MaterialThemeSpec.Default(
            colorScheme = dynamicColorScheme(
                seedColor = primaryColor,
                isDark = useDarkTheme
            ),
            shapes = androidx.compose.material3.Shapes(
                extraSmall = shapes.extraSmall,
                small = shapes.small,
                medium = shapes.medium,
                large = shapes.large,
                extraLarge = shapes.extraLarge
            )
        ),
        cupertino = CupertinoThemeSpec.Default(
            colorScheme = if (useDarkTheme)
                darkColorScheme(accent = primaryColor)
            else lightColorScheme(accent = primaryColor),
            shapes = com.slapps.cupertino.theme.Shapes(
                extraSmall = shapes.extraSmall,
                small = shapes.small,
                medium = shapes.medium,
                large = shapes.large,
                extraLarge = shapes.extraLarge
            )
        ),
        content = content
    )
}

