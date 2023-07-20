package cl.fernando.individual_14


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.fernando.individual_14.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnEnviar.setOnClickListener{
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.btnVerSaldo ->
                    binding.editTextMonto.setText(saldo.toString())
                R.id.btnIngresar -> ingresarSaldo()
                R.id.btnRetirar -> retirarSaldo()
                R.id.btnSalit -> finish()
            }
        }

    }

    private fun retirarSaldo() {
        saldo -= binding.editTextMonto.text.toString().toInt()
        Toast.makeText(applicationContext,"Su retiro ha sido procesado correctamente", Toast.LENGTH_LONG).show()
    }

    private fun ingresarSaldo() {
        saldo += binding.editTextMonto.text.toString().toInt()
        Toast.makeText(applicationContext,"Su saldo ha sido actualizado correctamente", Toast.LENGTH_LONG).show()


        // minuto 2:26
    }
}