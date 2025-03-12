package com.sistem.onlineshop.screen.ListItem

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.gson.Gson
import com.sistem.onlineshop.R
import com.sistem.onlineshop.screen.main.ItemsModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun ListItem(
    navController: NavController?,
    items : List<ItemsModel>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(
            horizontal = 10.dp,
            vertical = 5.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items.size){ index ->
               Row  (
                   modifier = Modifier.fillMaxWidth(),
               ) {
                   if (navController != null) {
                       RecommendedItem( navController, items, index)
                   }
               }
        }
    }
}



@Composable
fun RecommendedItem(navController: NavController, item: List<ItemsModel>, pos: Int) {

    Column (
        modifier = Modifier.background(colorResource(R.color.gray))
    ){

        AsyncImage(
                model = item[pos].picURL.firstOrNull(),
                contentDescription = item[pos].title,
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .padding(18.dp)
                    .background(
                        colorResource(R.color.white),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        val json = Gson().toJson(item[pos])

                        val encodedJson = URLEncoder.encode(json, StandardCharsets.UTF_8.toString())
                        navController.navigate("DetailsScreen/$encodedJson")
                    },
                contentScale = ContentScale.Fit
        )

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = item[pos].title,
        )

        Row(
            modifier = Modifier.padding(top = 10.dp).fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
            ){


                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Rating",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .align(Alignment.CenterVertically)

                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = item[pos].rating.toString(),
                    color = Color.Black,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    modifier = Modifier.padding(end = 2.dp),
                    text = "$${item[pos].price}",
                    color = colorResource(R.color.purple_700),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )

            }
        }
    }
}
