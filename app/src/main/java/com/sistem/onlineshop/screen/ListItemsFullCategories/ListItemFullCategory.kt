package com.sistem.onlineshop.screen.ListItemsFullCategories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sistem.onlineshop.R
import com.sistem.onlineshop.screen.ListItem.ListItem
import com.sistem.onlineshop.screen.main.ItemsModel
import kotlinx.coroutines.delay


@Composable
fun ListItemFullCategoryScreen(
    navController: NavController
) {
    val recommendedItems = remember { mutableStateListOf<ItemsModel>() }

    var showRecommended by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        // Simulate loading process
        delay(2000)

        recommendedItems.addAll(
            listOf(
                ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ),
                ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ),
                ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ),
                ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ), ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ), ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ), ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                ),
                ItemsModel(
                    title = "Google Pixel 9",
                    description = "A powerful smartphone with an amazing camera and AI features.",
                    picURL = arrayListOf(
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA",
                        "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"
                    ),
                    model = arrayListOf("128GB", "256GB"),
                    price = 1099.99,
                    rating = 4.9,
                    ratingCount = 2200.0,
                    numberInCart = 0,
                    showRecommended = true,
                    categoryId = "smartphones"
                )
            )
        )

        showRecommended = false
    }
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 50.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                 Box(
                     modifier = Modifier.
                         clickable {
                             navController.popBackStack()
                         }
                         .background(color = colorResource(R.color.gray), shape= RoundedCornerShape(100.dp))
                 ){
                     Image(
                         modifier = Modifier.padding(5.dp),
                         painter = painterResource(id = R.drawable.ic_arrow_back),
                         contentDescription = "Logo",
                         contentScale = ContentScale.Fit
                     )
                 }
            }
        },

        // main surface
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (showRecommended) {
                    CircularProgressIndicator()
                } else {
                    Box(
                        modifier = Modifier.height(800.dp)
                    ){
                        ListItem(
                            navController,
                            recommendedItems,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                        )
                    }
                }
            }
        },

        floatingActionButton = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                BottomMenu(navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

        )
}


@Composable
fun SectionTitle(title: String, actionText: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = title,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight =  FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = actionText,
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight =  FontWeight.Normal
        )
    }
}


@Composable
fun BottomMenu(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Row(
                modifier = Modifier

                    .background(
                        colorResource(R.color.purple_700),
                        shape = RoundedCornerShape(20.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomMenuIcon(icon = Icons.Default.Person, "Explorer", null )
                BottomMenuIcon(icon = Icons.Default.Favorite, "Favorite", null)
                BottomMenuIcon(icon = Icons.Default.List, "Orders", null)
                BottomMenuIcon(icon = Icons.Default.Person, "Profile", null)
            }

            Box(
                modifier = Modifier
                    .background(Color.Red, shape = RoundedCornerShape(15.dp))
            ) {
                BottomMenuIcon(icon = Icons.Default.ShoppingCart, "Basket", navController)
            }

        }
    }
}


@Composable
fun BottomMenuIcon(icon: ImageVector, text: String, navController: NavController?){
    Column(
        modifier = Modifier.height(60.dp)
            .clickable {
                navController?.navigate("CartScreen")
            }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(icon, contentDescription = text, tint = Color.White)
        Text(text, color = Color.White, fontSize = 10.sp )
    }
}