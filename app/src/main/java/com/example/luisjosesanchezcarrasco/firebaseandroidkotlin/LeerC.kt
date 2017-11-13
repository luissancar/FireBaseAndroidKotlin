package com.example.luisjosesanchezcarrasco.firebaseandroidkotlin


class LeerC() {
    public fun convierte(): Pair<String,String> {
        var cadenaentera="{'uno','dos'}"
        var cadena=(cadenaentera.substringAfter("{")).substringBefore("}")
        var uno=(cadena.substringAfter("'")).substringBefore("'")


         cadena=(cadenaentera.substringAfter(",")).substringBefore("}")
        var dos=(cadena.substringAfter("'")).substringBefore("'")
        return Pair(uno, dos)
    }
}
