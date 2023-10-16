package com.example.uisimplet1

import android.hardware.camera2.params.ColorSpaceTransform
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uisimplet1.ui.theme.UISimpleT1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UISimpleT1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = Color(0XFFFFFFFF)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            UserInfo(
                messageOne = "Hello Charlotte",
                messageTwo = "Find your best beans",
                image = R.drawable.person_i2jpg,
                imageDescription = "user profile image"
            )
            Spacer(modifier = Modifier.padding(15.dp))
            SearchBar()
            Spacer(modifier = Modifier.padding(15.dp))
            Surface(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .horizontalScroll(rememberScrollState())
                ) {
                    TagCard(
                        imageResourceVector = R.drawable.baseline_star_rate_24, message = "Newest"
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    TagCard(
                        imageResourceVector = R.drawable.baseline_local_fire_department_24,
                        message = "Popular"
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    TagCard(
                        imageResourceVector = R.drawable.baseline_bubble_chart_24,
                        message = "Favour"
                    )

                }
            }
            Surface(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    CoffeCard()
                    Spacer(modifier = Modifier.padding(7.dp))
                    CoffeCard(
                        imageCoffeBag = R.drawable.coffe_bag_2,
                        heading = "Indian Beans"
                    )
                    Spacer(modifier = Modifier.padding(7.dp))
                    CoffeCard(
                        imageCoffeBag = R.drawable.coffe_bag_3,
                        heading = "Premium Beans"
                    )

                }

            }
            Surface(
                modifier = Modifier.padding(vertical = 20.dp)
            ) {
                Text(
                    text = "Special Offer \uD83D\uDD25",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
//                    fontFamily = FontFamily.Serif
                )
            }

            //special discount horizontal cards
            SpecialDiscountCard(image = R.drawable.discount_coffe_bag)
        }
    }
}


@Composable
fun UserInfo(messageOne: String, messageTwo: String, image: Int, imageDescription: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Surface {
                Column {
                    Text(
                        text = messageOne,
                        color = Color(0xffbbbbbb),
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Monospace
                    )
                    Text(
                        text = messageTwo,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace

                    )
                }
            }
            Surface {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = imageDescription,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var value by remember {
        mutableStateOf("Ethopia Beans")
    }
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {

            TextField(value = value,
                onValueChange = {
                    value = it
                },
                maxLines = 1,
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth(1f),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Monospace, fontSize = 16.sp
                ),
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_search_24), ""
                    )
                }

            )

        }
    }
}


@Composable
fun TagCard(
    imageResourceVector: Int, message: String
) {
    Surface(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp)
            .clip(CircleShape),
        shadowElevation = 20.dp,
        color = Color(0xffFDF0F0)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,

            ) {
            Icon(
                painter = painterResource(id = imageResourceVector),
                contentDescription = "",
                modifier = Modifier.size(25.dp),
                tint = Color(0XFF999999)
            )

            Text(
                text = message, fontSize = 17.sp, fontFamily = FontFamily.Monospace,
                color = Color(0XFF999999)
            )
        }

    }
}


@Composable
fun CoffeCard(
    imageCoffeBag: Int = R.drawable.coffe_bag_1,
    heading: String = "Ethopia Beans",
    category: String = "Coffee Beans",
    cost: Double = 35.00
) {
    Card(
        modifier = Modifier
            .width(170.dp)
            .height(250.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffF5F5F5),
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = imageCoffeBag), contentDescription = "coffe bag",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))


            )
            Text(
                text = heading,
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )
            Text(text = category)
            Surface(
                color = Color(0xffF5F5F5),
                modifier = Modifier.fillMaxWidth()

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$ ${cost}0",
                        fontSize = 16.sp
                    )
                    Surface(
//                        color = Color(0XFFF0F0F0),
                        modifier = Modifier.clip(CircleShape),
                        tonalElevation = 4.dp,
                        shape = CircleShape,


                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "add to cart",
                            modifier = Modifier.padding(3.dp),
                            tint = Color.Black
                        )
                    }

                }
            }
        }
    }
}


@Composable
fun SpecialDiscountCard(image:Int) {
    Card(

    ) {
    Row {
        Image(painter = painterResource(id = image), contentDescription = "dicount product image")
        Surface {
            Column {

            }
        }
    }
    }
}
