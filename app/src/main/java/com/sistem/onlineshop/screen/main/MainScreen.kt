import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.sistem.onlineshop.R
import com.sistem.onlineshop.screen.Cart.CartScreen
import com.sistem.onlineshop.screen.ListItem.ListItem
import com.sistem.onlineshop.screen.main.CategoriesModel
import com.sistem.onlineshop.screen.main.ItemsModel
import com.sistem.onlineshop.screen.main.SliderModel
import kotlinx.coroutines.delay


@Composable
fun MainScreen(navController: NavController) {
    val banners = remember { mutableStateListOf<SliderModel>() }
    val categories = remember { mutableStateListOf<CategoriesModel>() }
    val recommendedItems = remember { mutableStateListOf<ItemsModel>() }

    var showBannerLoading by remember { mutableStateOf(true) }
    var showCategoryLoading by remember { mutableStateOf(true) }
    var showRecommended by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        // Simulate loading process
        delay(2000)
        banners.addAll(
            listOf(
                SliderModel("https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg"),
                SliderModel("https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8"),
                SliderModel("https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b47b70.JPG&type=auto&width=500&sign=EQ-ZaJxFc48rERXdxdU7KfotJGUYgmxaHaPwU7V6KNA"),
                SliderModel("https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b4b2b0.JPG&type=auto&width=500&sign=7v3YboaEOe62WxqZH5kQr5CksVyzZOr6GyV7p5igJZc"),
            )
        )

        categories.addAll(
            listOf(
                CategoriesModel("Music", 1, R.drawable.ic_headset),
                CategoriesModel("Computers", 2, R.drawable.ic_computer),
                CategoriesModel("Phones", 3, R.drawable.ic_phone),
                CategoriesModel("Games", 4, R.drawable.ic_game),
                CategoriesModel("Consoles", 4, R.drawable.ic_videogame),
                CategoriesModel("Games", 4, R.drawable.ic_book),
            )
        )


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

        showBannerLoading = false
        showCategoryLoading = false
        showRecommended = false
    }
    Scaffold(
        // top app bar
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 40.dp)
                    .padding(top = 30.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(
                        "Welcome Back",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        "Victor",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.fav_icon),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "search",
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

                if (showBannerLoading) {
                    CircularProgressIndicator()

                } else {
                    Banners(banners)
                }

                SectionTitle("Popular Products", "View All", navController)

                if (showCategoryLoading) {
                    CircularProgressIndicator()

                } else {
                    CategoryList(categories)
                }

                SectionTitle("Recommended Products", "View All", navController)

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
               BottomMenu(
                    navController
               )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

    )
}



@Composable
fun Banners(banners: SnapshotStateList<SliderModel>) {
    AutoSlidingCarousel(banners = banners)
}

@Composable
fun AutoSlidingCarousel(modifier: Modifier = Modifier,
                        pagerState: PagerState = remember { PagerState() },
                        banners: SnapshotStateList<SliderModel>
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    Column(modifier = modifier.padding(vertical = 16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                colorResource(R.color.purple_700)
            ),
            count = banners.size,
            state = pagerState
        ) {page ->
            if (banners.isNotEmpty()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(banners[page].url)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Fit ,
                    modifier = Modifier.fillMaxHeight().padding(horizontal = 16.dp, vertical = 8.dp).height(150.dp)
                )
            } else {
                CircularProgressIndicator(
                    color = Color.Black,
                    modifier = Modifier.fillMaxSize()
                )
            }


        }

        DotIndicator(
            modifier = Modifier.padding(top = 15.dp).padding(horizontal = 8.dp).align(Alignment.CenterHorizontally),
            totalDots = banners.size,
            selectedIndex = if(isDragged)pagerState.currentPage else pagerState.targetPage,
            dotSize = 8.dp,
        )
    }
}

@Composable
fun DotIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor:Color = colorResource(R.color.purple_700),
    unselectedColor: Color = colorResource(R.color.teal_700),
    dotSize: Dp
){
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ){
        items(totalDots) { index ->

            IndicatorDot(
                color = if(index == selectedIndex) selectedColor else unselectedColor,
                size = dotSize
            )

            if(index != totalDots-1){
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(modifier = modifier
        .size(size)
        .clip(CircleShape)
        .background(color)
    )
}

@Composable
fun SectionTitle(title: String, actionText: String, navController: NavController){
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
            modifier = Modifier.clickable{
                navController.navigate("ListItemFullCategoryScreen")//you can add the category title and read from db or api the category for all the lists
            },
            text = actionText,
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight =  FontWeight.Normal
        )
    }
}


@Composable
fun CategoryList(categories: SnapshotStateList<CategoriesModel>) {

    var selectedIndex by remember { mutableStateOf(-1) }

    LazyRow (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ){
        items(categories.size){ index ->
            CategoryItem(
                item = categories[index],
                isSelected = selectedIndex == index,
                onItemClicked = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Composable
fun CategoryItem(item: CategoriesModel, isSelected: Boolean , onItemClicked: () -> Unit) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable (
                    onClick = onItemClicked
                )
                .background(
                    color = if (isSelected) colorResource(R.color.purple_700) else colorResource(R.color.gray),
                    shape = RoundedCornerShape(8.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ){

            Box(
                modifier = Modifier.padding(10.dp)
            ){
                AsyncImage(
                    contentDescription = item.title,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.picUrl)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier.size(30.dp),
                    contentScale = ContentScale.Inside,
                    colorFilter = if(isSelected) ColorFilter.tint(Color.White) else ColorFilter.tint(Color.Black)
                )

            }

            if(isSelected) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
}


@Composable
fun BottomMenu(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    colorResource(R.color.purple_700),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomMenuIcon(icon = Icons.Default.Person, "Explorer", navController)
            BottomMenuIcon(icon = Icons.Default.ShoppingCart, "Cart",navController)
            BottomMenuIcon(icon = Icons.Default.Favorite, "Favorite",navController)
            BottomMenuIcon(icon = Icons.Default.List, "Orders",navController)
            BottomMenuIcon(icon = Icons.Default.Person, "Profile", navController)//you can add the category title and read from db or api the category for all the lists
        }
    }
}

@Composable
fun BottomMenuIcon(icon: ImageVector, text: String, navController: NavController){
    Column(
        modifier = Modifier.height(60.dp)
            .clickable { navController.navigate("CartScreen") }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Icon(icon, contentDescription = text, tint = Color.White)
        Text(text, color = Color.White, fontSize = 10.sp )
    }
}