package com.sistem.onlineshop.screen.Cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.sistem.onlineshop.R
import com.sistem.onlineshop.screen.main.ItemsModel


@Composable
fun CartScreen(
    navController: NavController
){
    val cartItems = remember {
        mutableStateListOf(
            ItemsModel(
                title = "Google Pixel 9",
                description = "...",
                picURL = arrayListOf(
                    "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b44f08.JPG&type=auto&width=500&sign=ItSIWGwrORJHgU6bKNhBKH7JsDgSB78ABlT3hpmR1Dg"
                ),
                model = arrayListOf("Google Pixel 9 PRO", "XL PRO MAX", "FLAGSHIP"),
                price = 550.4,
                numberInCart = 3
            ),
            ItemsModel(
                title = "Google Pixel 9 XL",
                description = "...",
                picURL = arrayListOf(
                    "https://static2.evomag.ro/img?extend=white&file=products%2F4176%2F4176818%2Ftelefon-mobil-google-pixel-9-p-66bf053b46d88.JPG&type=auto&width=500&sign=KciwNoQRqub1xzlVqwIIFVVa0skH5a-o82ZTwZePyO8"
                ),
                model = arrayListOf("Google Pixel 9 XL", "XL PRO", "FLAGSHIP"),
                price = 650.4,
                numberInCart = 2
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        ConstraintLayout(
            modifier = Modifier.padding(top = 50.dp)
        ) {
            val (backBtn, cartTxt , cartList, total) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(backBtn) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Text(
                text = "Cumparaturile tale",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(cartTxt) {
                        centerHorizontallyTo(parent)
                    }
                    .fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            ConstraintLayout (
                modifier = Modifier
                    .constrainAs(cartList) {
                        top.linkTo(parent.bottom)
                        bottom.linkTo(total.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

                CartList(
                    cartItems
                )
            }

            ConstraintLayout (
                modifier = Modifier
                    .constrainAs(total) {

                        top.linkTo(cartList.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                }
            ){

                 val itemTotal = calculatorCart(cartItems)

                CartSummary(
                    itemTotal,
                    20.0,
                    30.3
                )
            }


        }
    }

}


fun calculatorCart(cartItems: SnapshotStateList<ItemsModel>): Double {
    val percentTax = 0.02
    return cartItems.sumOf { it.numberInCart * (it.price + (it.price * percentTax)) }
}


@Composable
fun CartList(
    cartItems: SnapshotStateList<ItemsModel>
){
    LazyColumn (
        Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 50.dp)
            .padding(bottom = 270.dp)
    ) {
        items(cartItems) { item ->
            CartItem(
                item = item,
                onQuantityChange = { updatedItem -> //updated item received inside my method
                    val index = cartItems.indexOf(item)
                    if (index != -1) {
                        cartItems[index] = updatedItem
                    }
                }
            )
        }
    }
}

@Composable
fun CartItem(
    item: ItemsModel,
    onQuantityChange: (ItemsModel) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        val (pic, titleText, feeEachTime, totalEachTime, Quantity) = createRefs()

        Image(
            painter = rememberAsyncImagePainter(item.picURL[0]),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .background(colorResource(R.color.gray), shape = RoundedCornerShape(10.dp))
                .padding(8.dp)
                .constrainAs(pic) {
                    top.linkTo(parent.top)
                    bottom.linkTo(pic.bottom)
                }
        )

        Text(
            text = item.title,
            modifier = Modifier
                .constrainAs(titleText) {
                    top.linkTo(pic.top)
                    start.linkTo(pic.end, margin = 8.dp)
                }
                .padding(start = 8.dp)
        )

        Text(
            text = "$${item.price}",
            color = colorResource(R.color.purple_700),
            modifier = Modifier
                .constrainAs(feeEachTime) {
                    start.linkTo(titleText.start)
                    top.linkTo(titleText.bottom, margin = 10.dp)
                }
                .padding(start = 8.dp, top = 8.dp)
        )

        Text(
            text = "$${item.numberInCart * item.price}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(totalEachTime) {
                    start.linkTo(feeEachTime.start)
                    top.linkTo(feeEachTime.bottom, margin = 10.dp)
                }
                .padding(start = 8.dp)
        )

        ConstraintLayout(
            modifier = Modifier
                .width(100.dp)
                .constrainAs(Quantity) {
                    end.linkTo(parent.end)
                    bottom.linkTo(pic.bottom)
                }
                .background(colorResource(R.color.gray), shape = RoundedCornerShape(10.dp))
        ) {
            val (plusCartBtn, minusCartBtn, numberItemTxt) = createRefs()

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(28.dp)
                    .background(colorResource(R.color.white), shape = RoundedCornerShape(10.dp))
                    .clickable {
                        if (item.numberInCart > 1) {
                            onQuantityChange(item.copy(numberInCart = item.numberInCart - 1))
                        }
                    }
                    .constrainAs(minusCartBtn) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Text(
                    text = "-",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Text(
                text = item.numberInCart.toString(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(numberItemTxt) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(28.dp)
                    .background(
                        colorResource(R.color.purple_700),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onQuantityChange(item.copy(numberInCart = item.numberInCart + 1))
                    }
                    .constrainAs(plusCartBtn) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Text(
                    text = "+",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}



@Composable
fun CartSummary(
    itemTotal: Double,
    tax: Double,
    delivery: Double,
){
    Column(
        modifier = Modifier
            .background(colorResource(R.color.gray))
            .fillMaxWidth()
            .padding(16.dp)
     ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)){
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "Item total:",
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black)
            )

            Text(text = "$${itemTotal}", fontWeight = FontWeight.Bold, color = colorResource(R.color.purple_700))
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)){
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "Tax total:",
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black)
            )

            Text(text = "$$tax ", fontWeight = FontWeight.Bold, color = colorResource(R.color.purple_700))
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)){
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "Delivery: ",
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black)
            )

            Text(text = "$$delivery", fontWeight = FontWeight.Bold, color = colorResource(R.color.purple_700))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {

                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.purple_700)),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .height(50.dp)
            ){
                Text(
                    text = "Finalizeaza ",
                    color = colorResource(R.color.white)
                )
            }

        }
    }
}