package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridapp.data.DataSource
import com.example.gridapp.model.Topic
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(
                        topics = DataSource.topics,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun TopicGrid(topics: List<Topic>, modifier: Modifier = Modifier){
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        )
        {
            items(topics){ topic ->
                TopicItem(topic = topic)
            }
        }
    }

    @Composable
    fun TopicItem(topic: Topic, modifier: Modifier = Modifier){
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = modifier.fillMaxWidth()
        )
        {
            Row {
                Image(
                    painter = painterResource(id = topic.imageResourceId),
                    contentDescription = stringResource(id = topic.nameStringResourceId),
                    modifier = modifier.size(68.dp, 68.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = topic.nameStringResourceId),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(start = 8.dp))
                        Text(
                            text = topic.availableCourses.toString(),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TopicItemPreview(){
        GridAppTheme {
            TopicGrid(DataSource.topics)
        }
    }
}
