private const val lifecycleVersion = "2.6.0"
private const val navigationVersion = "2.5.2"
private const val roomVersion = "2.5.0" // <-- 2.4.3
private const val pagingVersion = "3.2.1"
private const val coroutinesVersion = "1.7.3"
private const val fragmentVersion = "1.5.5"
private const val dataStoreVersion = "1.0.0"

object ArchitectureComponent {
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:$lifecycleVersion"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

    const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentVersion"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomPaging = "androidx.room:room-paging:$roomVersion"
    const val dataStore = "androidx.datastore:datastore-preferences:$dataStoreVersion"

    const val paging = "androidx.paging:paging-runtime:$pagingVersion"
    const val pagingCommon = "androidx.paging:paging-common:$pagingVersion"

    const val workManager = "androidx.work:work-runtime-ktx:2.8.1"

    const val sqlite = "androidx.sqlite:sqlite-ktx:2.1.0"
}