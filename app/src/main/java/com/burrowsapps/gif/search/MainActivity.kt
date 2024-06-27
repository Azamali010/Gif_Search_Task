package com.burrowsapps.gif.search

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices.PIXEL_7_PRO
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.burrowsapps.gif.search.ui.giflist.GifScreen
import com.burrowsapps.gif.search.ui.license.LicenseScreen
import com.burrowsapps.gif.search.ui.theme.GifTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      GifTheme {
        MainScreen()
      }
    }
  }
}

@Preview(
  name = "dark",
  showBackground = true,
  device = PIXEL_7_PRO,
  locale = "en",
  showSystemUi = true,
  uiMode = UI_MODE_NIGHT_YES,
)
@Preview(
  name = "light",
  showBackground = true,
  device = PIXEL_7_PRO,
  locale = "en",
  showSystemUi = true,
  uiMode = UI_MODE_NIGHT_NO,
)
@Composable
private fun DefaultPreview(navController: NavHostController = rememberNavController()) {
  GifTheme {
    MainScreen(
      navController = navController,
    )
  }
}


@Composable
fun MainScreen(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
) {
  Scaffold(
    modifier = modifier,
  ) { innerPadding ->
    NavHost(
      modifier = Modifier.padding(innerPadding),
      navController = navController,
      startDestination = Screen.Gif.route,
    ) {
      composable(
        route = Screen.Gif.route,
      ) {
        GifScreen(
          navController = navController,
        )
      }
      composable(
        route = Screen.License.route,
      ) {
        LicenseScreen(
          navController = navController,
        )
      }
    }
  }
}

sealed class Screen(val route: String) {
  data object Gif : Screen("gif")

  data object License : Screen("license")
}
