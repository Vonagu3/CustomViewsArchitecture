package com.example.customviewsarchitecture.main

interface NavigationCommunication {

    interface Observe: Communication.Observe<Screen>

    interface Update: Communication.Update<Screen>

    interface Mutable: Observe, Update

    class Base: Communication.Abstract<Screen>(), Mutable
}

