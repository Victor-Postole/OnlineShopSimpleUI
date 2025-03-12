package com.sistem.onlineshop.screen.DetailsItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.sistem.onlineshop.R
import com.sistem.onlineshop.screen.main.ItemsModel


@Composable
fun DetailsScreen(
    navController: NavController,
    item: ItemsModel,
    onAddToCartClick:((ItemsModel) -> Unit)?,
) {
    var selectedImageUrl by remember { mutableStateOf(item.picURL.first()) }
    var selectedModelIndex by remember { mutableStateOf(-1) }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp)
                .fillMaxSize()
        ) {
            val (back, fav) = createRefs()

            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier.
                    clickable {
                        navController.popBackStack()
                    }
                    .constrainAs(back) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Image(
                painter = painterResource(R.drawable.fav_icon),
                contentDescription = null,
                modifier = Modifier.constrainAs(fav) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }

        Image(
            painter = rememberAsyncImagePainter(model = selectedImageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .height(290.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        )

        LazyRow(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            items(item.picURL) { imageUrl ->
                ImageThumbnail(
                    imageUrl = imageUrl.toString(),
                    isSelected = selectedImageUrl ==  imageUrl.toString(),
                    onClick = { selectedImageUrl = imageUrl.toString() }
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ){
            Text(
                text = item.title,
                fontSize = 23.sp,
                modifier = Modifier.padding(end = 10.dp).fillMaxWidth().weight(1f)
            )

            Text(
                text = "$${item.price}",
                fontSize = 23.sp,
                modifier = Modifier.padding(end = 10.dp).fillMaxWidth().weight(1f)
            )
        }

        RatingBar(
            rating = item.rating,
        )

        ModelSelector(
            item.model,
            selectedModelIndex = selectedModelIndex,
            onModelSelected = {selectedModelIndex = it}
        )

        Text(
            text = item.description,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxSize().padding(vertical = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    if (onAddToCartClick != null) {
                        onAddToCartClick(item)
                    }
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.purple_700)),
                modifier = Modifier.weight(1f).padding(end = 8.dp).height(50.dp)
            ){
                Text(
                    text = "Add to cart",
                    color = colorResource(R.color.white)
                )
            }

            IconButton(
                onClick = {
                    if (onAddToCartClick != null) {
                        onAddToCartClick(item)
                    }
                },
                modifier = Modifier.background(
                    colorResource(R.color.gray),
                    shape = RoundedCornerShape(10.dp)
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Black
                )
            }

        }

    }
}



@Composable
fun RatingBar(
    rating: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 16.dp)
    ){
        Text(
            text = "Select model",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "Rating",
            modifier = Modifier
                .padding(end = 15.dp)
                .align(Alignment.CenterVertically)
        )

        Text(
            text = "$rating rating",
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ModelSelector(
    models: List<String>,
    selectedModelIndex: Int,
    onModelSelected: (Int) -> Unit
){
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp)
    ){
        itemsIndexed(models) { index, model ->
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(48.dp)
                    .then(
                        if (index == selectedModelIndex) {
                            Modifier.border(1.dp, colorResource(R.color.purple_700), RoundedCornerShape(10.dp))
                        }else{
                            Modifier
                        }
                    )
                    .background(
                        if (index == selectedModelIndex) colorResource(R.color.purple_700) else colorResource(R.color.gray), shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onModelSelected(index)
                    }
                    .padding(horizontal = 16.dp)
            ){
                Text(
                    text = model,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = if(index == selectedModelIndex) colorResource(R.color.white) else colorResource(R.color.purple_700),
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
    }
}

@Composable
fun ImageThumbnail(
    imageUrl: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backColor = if (isSelected) colorResource(R.color.purple_700) else colorResource(R.color.gray)

    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(55.dp)
            .then(
                if (isSelected) {
                    Modifier.border(1.dp, colorResource(R.color.purple_200), RoundedCornerShape(10.dp))
                } else {
                    Modifier
                }
            )
            .background(color = backColor, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .padding(4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().padding(4.dp)
        )
    }
}