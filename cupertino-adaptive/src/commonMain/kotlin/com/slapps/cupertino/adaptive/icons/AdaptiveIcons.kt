

package com.slapps.cupertino.adaptive.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.slapps.cupertino.adaptive.LocalTheme
import com.slapps.cupertino.adaptive.Theme
import com.slapps.cupertino.icons.CupertinoIcons
import com.slapps.cupertino.icons.outlined.ArrowClockwise
import com.slapps.cupertino.icons.outlined.Bell
import com.slapps.cupertino.icons.outlined.Calendar
import com.slapps.cupertino.icons.outlined.Cart
import com.slapps.cupertino.icons.outlined.Checkmark
import com.slapps.cupertino.icons.outlined.CheckmarkCircle
import com.slapps.cupertino.icons.outlined.ChevronBackward
import com.slapps.cupertino.icons.outlined.ChevronDown
import com.slapps.cupertino.icons.outlined.ChevronForward
import com.slapps.cupertino.icons.outlined.ChevronUp
import com.slapps.cupertino.icons.outlined.Ellipsis
import com.slapps.cupertino.icons.outlined.Envelope
import com.slapps.cupertino.icons.outlined.ExclamationmarkTriangle
import com.slapps.cupertino.icons.outlined.FaceSmiling
import com.slapps.cupertino.icons.outlined.Gearshape
import com.slapps.cupertino.icons.outlined.HandThumbsup
import com.slapps.cupertino.icons.outlined.Heart
import com.slapps.cupertino.icons.outlined.House
import com.slapps.cupertino.icons.outlined.InfoCircle
import com.slapps.cupertino.icons.outlined.ListBullet
import com.slapps.cupertino.icons.outlined.Location
import com.slapps.cupertino.icons.outlined.Lock
import com.slapps.cupertino.icons.outlined.MagnifyingGlass
import com.slapps.cupertino.icons.outlined.Mappin
import com.slapps.cupertino.icons.outlined.Paperplane
import com.slapps.cupertino.icons.outlined.Pencil
import com.slapps.cupertino.icons.outlined.Person
import com.slapps.cupertino.icons.outlined.PersonCropCircle
import com.slapps.cupertino.icons.outlined.PersonCropSquare
import com.slapps.cupertino.icons.outlined.Phone
import com.slapps.cupertino.icons.outlined.Play
import com.slapps.cupertino.icons.outlined.Plus
import com.slapps.cupertino.icons.outlined.PlusCircle
import com.slapps.cupertino.icons.outlined.RectanglePortraitAndArrowForward
import com.slapps.cupertino.icons.outlined.SquareAndArrowUp
import com.slapps.cupertino.icons.outlined.SquareAndPencil
import com.slapps.cupertino.icons.outlined.Star
import com.slapps.cupertino.icons.outlined.Trash
import com.slapps.cupertino.icons.outlined.WrenchAndScrewdriver
import com.slapps.cupertino.icons.outlined.Xmark
import com.slapps.cupertino.icons.outlined.XmarkCircle

object AdaptiveIcons {
    object Filled

    object Outlined

    /**
     * Adaptive vector icon based on current theme.
     *
     * To retrieve system images on iOS use [painter]
     * */
    @Composable
    fun vector(
        material: () -> ImageVector,
        cupertino: () -> ImageVector,
    ): ImageVector =
        when (LocalTheme.current) {
            Theme.Cupertino -> cupertino()
            else -> material()
        }

    /**
     * Native adaptive icon based on current theme.
     *
     * - For [Theme.Material3] and [Theme.Cupertino] on non-iOS it return painter from [material] vector.
     * - For [Theme.Cupertino] on iOS it returns SF Symbol with system name [cupertino]
     * */
    @Composable
    fun painter(
        material: () -> ImageVector,
        cupertino: () -> String,
    ): Painter =
        when (LocalTheme.current) {
            Theme.Cupertino -> systemImage(cupertino()) ?: rememberVectorPainter(material())
            else -> rememberVectorPainter(material())
        }
}

val AdaptiveIcons.Outlined.AccountBox
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.AccountBox },
            cupertino = { CupertinoIcons.Outlined.PersonCropSquare },
        )
val AdaptiveIcons.Outlined.AccountCircle
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.AccountCircle },
            cupertino = { CupertinoIcons.Outlined.PersonCropCircle },
        )
val AdaptiveIcons.Outlined.Add
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Add },
            cupertino = { CupertinoIcons.Outlined.Plus },
        )
val AdaptiveIcons.Outlined.AddCircle
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.AddCircle },
            cupertino = { CupertinoIcons.Outlined.PlusCircle },
        )

// val AdaptiveIcons.Outlined.ArrowBack
//    @Composable
//    get() = AdaptiveIcons.icon(
//        material = Icons.Outlined.ArrowBack,
//        cupertino = CupertinoIcons.Outlined.ChevronBackward
//    )
// val AdaptiveIcons.Outlined.ArrowDropDown
//    @Composable
//    get() = AdaptiveIcons.icon(
//        material = Icons.Outlined.ArrowDropDown,
//        cupertino = CupertinoIcons.Outlined.ArrowDropDown
//    )
// val AdaptiveIcons.Outlined.ArrowForward
//    @Composable
//    get() = AdaptiveIcons.icon(
//        material = Icons.Outlined.ArrowForward,
//        cupertino = CupertinoIcons.Outlined.ArrowForward
//    )
val AdaptiveIcons.Outlined.Build
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Build },
            cupertino = { CupertinoIcons.Outlined.WrenchAndScrewdriver },
        )
val AdaptiveIcons.Outlined.Call
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Call },
            cupertino = { CupertinoIcons.Outlined.Phone },
        )
val AdaptiveIcons.Outlined.Check
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Check },
            cupertino = { CupertinoIcons.Outlined.Checkmark },
        )
val AdaptiveIcons.Outlined.CheckCircle
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.CheckCircle },
            cupertino = { CupertinoIcons.Outlined.CheckmarkCircle },
        )
val AdaptiveIcons.Outlined.Clear
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Clear },
            cupertino = { CupertinoIcons.Outlined.XmarkCircle },
        )
val AdaptiveIcons.Outlined.Close
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Close },
            cupertino = { CupertinoIcons.Outlined.Xmark },
        )
val AdaptiveIcons.Outlined.Create
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Create },
            cupertino = { CupertinoIcons.Outlined.SquareAndPencil },
        )
val AdaptiveIcons.Outlined.DateRange
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.DateRange },
            cupertino = { CupertinoIcons.Outlined.Calendar },
        )
val AdaptiveIcons.Outlined.Delete
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Delete },
            cupertino = { CupertinoIcons.Outlined.Trash },
        )
val AdaptiveIcons.Outlined.Done
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Done },
            cupertino = { CupertinoIcons.Outlined.Checkmark },
        )
val AdaptiveIcons.Outlined.Edit
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Edit },
            cupertino = { CupertinoIcons.Outlined.Pencil },
        )
val AdaptiveIcons.Outlined.Email
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Email },
            cupertino = { CupertinoIcons.Outlined.Envelope },
        )
val AdaptiveIcons.Outlined.ExitToApp
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.AutoMirrored.Outlined.ExitToApp },
            cupertino = { CupertinoIcons.Outlined.RectanglePortraitAndArrowForward },
        )
val AdaptiveIcons.Outlined.Face
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Face },
            cupertino = { CupertinoIcons.Outlined.FaceSmiling },
        )
val AdaptiveIcons.Outlined.Favorite
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Favorite },
            cupertino = { CupertinoIcons.Outlined.Heart },
        )
val AdaptiveIcons.Outlined.FavoriteBorder
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.FavoriteBorder },
            cupertino = { CupertinoIcons.Outlined.Heart },
        )
val AdaptiveIcons.Outlined.Home
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Home },
            cupertino = { CupertinoIcons.Outlined.House },
        )
val AdaptiveIcons.Outlined.Info
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Info },
            cupertino = { CupertinoIcons.Outlined.InfoCircle },
        )
val AdaptiveIcons.Outlined.KeyboardArrowDown
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.KeyboardArrowDown },
            cupertino = { CupertinoIcons.Outlined.ChevronDown },
        )
val AdaptiveIcons.Outlined.KeyboardArrowLeft
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.AutoMirrored.Outlined.KeyboardArrowLeft },
            cupertino = { CupertinoIcons.Outlined.ChevronBackward },
        )
val AdaptiveIcons.Outlined.KeyboardArrowRight
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.AutoMirrored.Outlined.KeyboardArrowRight },
            cupertino = { CupertinoIcons.Outlined.ChevronForward },
        )

val AdaptiveIcons.Outlined.KeyboardArrowUp
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.KeyboardArrowUp },
            cupertino = { CupertinoIcons.Outlined.ChevronUp },
        )
val AdaptiveIcons.Outlined.List
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.AutoMirrored.Outlined.List },
            cupertino = { CupertinoIcons.Outlined.ListBullet },
        )
val AdaptiveIcons.Outlined.LocationOn
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.LocationOn },
            cupertino = { CupertinoIcons.Outlined.Location },
        )
val AdaptiveIcons.Outlined.Lock
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Lock },
            cupertino = { CupertinoIcons.Outlined.Lock },
        )
val AdaptiveIcons.Outlined.MailOutline
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.MailOutline },
            cupertino = { CupertinoIcons.Outlined.Envelope },
        )
val AdaptiveIcons.Outlined.Menu
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Menu },
            cupertino = { CupertinoIcons.Outlined.ListBullet },
        )
val AdaptiveIcons.Outlined.MoreVert
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.MoreVert },
            cupertino = { CupertinoIcons.Outlined.Ellipsis },
        )
val AdaptiveIcons.Outlined.Notifications
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Notifications },
            cupertino = { CupertinoIcons.Outlined.Bell },
        )
val AdaptiveIcons.Outlined.Person
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Person },
            cupertino = { CupertinoIcons.Outlined.Person },
        )
val AdaptiveIcons.Outlined.Phone
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Phone },
            cupertino = { CupertinoIcons.Outlined.Phone },
        )
val AdaptiveIcons.Outlined.Place
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Place },
            cupertino = { CupertinoIcons.Outlined.Mappin },
        )
val AdaptiveIcons.Outlined.PlayArrow
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.PlayArrow },
            cupertino = { CupertinoIcons.Outlined.Play },
        )
val AdaptiveIcons.Outlined.Refresh
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Refresh },
            cupertino = { CupertinoIcons.Outlined.ArrowClockwise },
        )
val AdaptiveIcons.Outlined.Search
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Search },
            cupertino = { CupertinoIcons.Outlined.MagnifyingGlass },
        )
val AdaptiveIcons.Outlined.Send
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.AutoMirrored.Outlined.Send },
            cupertino = { CupertinoIcons.Outlined.Paperplane },
        )
val AdaptiveIcons.Outlined.Settings
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Settings },
            cupertino = { CupertinoIcons.Outlined.Gearshape },
        )
val AdaptiveIcons.Outlined.Share
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Share },
            cupertino = { CupertinoIcons.Outlined.SquareAndArrowUp },
        )
val AdaptiveIcons.Outlined.ShoppingCart
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.ShoppingCart },
            cupertino = { CupertinoIcons.Outlined.Cart },
        )
val AdaptiveIcons.Outlined.Star
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Star },
            cupertino = { CupertinoIcons.Outlined.Star },
        )
val AdaptiveIcons.Outlined.ThumbUp
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.ThumbUp },
            cupertino = { CupertinoIcons.Outlined.HandThumbsup },
        )
val AdaptiveIcons.Outlined.Warning
    @Composable
    get() =
        AdaptiveIcons.vector(
            material = { Icons.Outlined.Warning },
            cupertino = { CupertinoIcons.Outlined.ExclamationmarkTriangle },
        )

@Composable
internal expect fun systemImage(name: String): Painter?
