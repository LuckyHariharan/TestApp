package com.example.test.di.components

import com.example.test.di.modules.DatabaseModule
import com.example.test.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

// di/components/AppComponent.kt
@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    // Define where to inject the dependencies
    // Example: fun inject(activity: MainActivity)
}
