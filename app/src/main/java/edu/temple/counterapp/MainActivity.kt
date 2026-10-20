package edu.temple.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {


    val counterViewModel by viewModels<CounterViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter( //Where we start, call to fun Counter below
                        counterViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(counterViewModel : CounterViewModel, modifier: Modifier = Modifier) {

    var countValue by rememberSaveable{mutableIntStateOf(0)}

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button({
            counterViewModel.counterValue.intValue++
        }) { Text("Up") }

        Text( //same as textview?
            text = counterViewModel.counterValue.intValue.toString(),
            modifier = modifier,
            fontSize = 48.sp

        )

        Button({
            if (counterViewModel.counterValue.intValue > 0)
                counterViewModel.counterValue.intValue--
        }) { Text("Down") }
    }
}



