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
        val monto = binding.editTextMonto.text.toString().toInt()
        if(monto <= saldo){
            saldo -= monto
            limpiarMonto()
            crearMensaje("Su retiro ha sido procesado correctamente")
        } else {
            crearMensaje("Su saldo es menor que la cantidad que quiere retirar, intente con una cifra menor")

        }

    }

    private fun ingresarSaldo() {
        saldo += binding.editTextMonto.text.toString().toInt()
        limpiarMonto()
        crearMensaje("Su saldo ha sido actualizado correctamente")


    }

    fun limpiarMonto(){
        binding.editTextMonto.text.clear()
    }

    fun crearMensaje(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
    }
}