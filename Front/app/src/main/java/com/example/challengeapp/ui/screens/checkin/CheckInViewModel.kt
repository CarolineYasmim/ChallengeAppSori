import androidx.lifecycle.ViewModel
import com.example.challengeapp.Model.Feeling
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CheckInViewModel : ViewModel() {

    private val _currentFeeling = MutableStateFlow<Feeling>(Feeling.NEUTRO)
    val currentFeeling: StateFlow<Feeling> = _currentFeeling.asStateFlow()

    private val _noteText = MutableStateFlow("")
    val noteText: StateFlow<String> = _noteText.asStateFlow()

    // 👇 Nova lista de anotações (imutável para a UI)
    private val _notes = MutableStateFlow<List<String>>(emptyList())
    val notes: StateFlow<List<String>> = _notes.asStateFlow()

    fun setNote(note: String) {
        _noteText.value = note
    }

    fun saveNote() {
        val note = _noteText.value.trim()
        if (note.isNotBlank()) {
            _notes.value = _notes.value + note
            _noteText.value = "" // limpa após salvar
        }
    }

    fun setFeeling(feeling: Feeling) {
        _currentFeeling.value = feeling
    }
}
