package com.sistem.onlineshop

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sistem.onlineshop.screen.Cart.CartScreen
import com.sistem.onlineshop.screen.DetailsItem.DetailsScreen
import com.sistem.onlineshop.screen.ListItemsFullCategories.ListItemFullCategoryScreen
import com.sistem.onlineshop.screen.intro.IntroScreen
import com.sistem.onlineshop.screen.main.ItemsModel
import androidx.navigation.navArgument
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*(
            DetailsScreen(

                ItemsModel(
                    title = "Google Pixel 9",
                    description = "Telefon Mobil Google Pixel 9 Pro, Procesor Google Tensor G4 Octa-core, LTPO OLED Capacitive Touchscreen 6.3, 16GB RAM, 128GB Flash, Camera Tripla 50+48+48MP, Wi-Fi, 5G, Dual SIM, Android (Negru)\n",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf(
                        "Google pixel 9 PRO",
                        "XL PRO MAX",
                        "FLAGSHIP"
                    )
                ),
                onBackClick = null,
                onAddToCartClick = null,
                onRemoveFromCartClick =  null,
                onCartCLick = null,
            )

             */
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "IntroScreen") {
                composable("IntroScreen") {
                    IntroScreen(navController)
                }
                composable("MainScreen") {
                    MainScreen(navController)
                }

                composable("ListItemFullCategoryScreen") {
                    ListItemFullCategoryScreen(navController)
                }

                composable("CartScreen") {
                    CartScreen(navController)
                }

                composable(
                    route = "DetailsScreen/{item}",
                    arguments = listOf(navArgument("item") { type = NavType.StringType })
                ) { backStackEntry ->
                    val json = backStackEntry.arguments?.getString("item")
                    val item = Gson().fromJson(json, ItemsModel::class.java)

                    DetailsScreen(navController, item ,null)
                }
            }
        }
    }
}

