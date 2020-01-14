package ru.boronin.cardtasker.features.main.di.app

import dagger.Module
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent

/**
 * Created by Sergey Boronin on 12.11.2019.
 */

@Module(subcomponents = [
    ActivityComponent::class
])
class AppSubcomponents