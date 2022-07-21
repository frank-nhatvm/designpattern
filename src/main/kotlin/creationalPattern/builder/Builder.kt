package creationalPattern.builder

class Mail internal  constructor(
   val to: List<String>,
    val cc: List<String>?,
   val title: String?,
   val body: String?,
   val isImportant: Boolean
){


    class Builder{
        private var _to: List<String> = listOf()
        private var _cc: List<String>? = null
        private var _title: String? = null
        private var _body: String? = null
        private var _isImportant: Boolean? = null

        fun to(list: List<String>): Builder{
            this._to = list
            return this
        }

        fun cc(list: List<String>): Builder{
            this._cc = list
            return this
        }

        fun title(value: String): Builder{
            this._title = value
            return this
        }

        fun body(value: String):Builder{
            this._body = value
            return this
        }

        fun isImportant(value: Boolean):Builder{
            this._isImportant = value
            return this
        }

        fun build():Mail{
            return Mail(to = _to, cc = _cc, title = _title, body = _body, isImportant = _isImportant ?: false)
        }

    }
}

fun main() {
    val mail = Mail.Builder().cc(listOf("a@b.com")).title("Onboard").build()
    println("mail: ${mail.cc}")
}

