package br.com.curymorais.tembicibycury.data

import androidx.room.RoomDatabase

//@Database(
//    entities = [GitRepo::class],
//    version = 1,
//    exportSchema = false
//)
abstract class WishListDatabase : RoomDatabase() {

//    abstract fun itemDao(): ItemDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: WishListDatabase? = null
//
//        fun getDatabase(
//            context: Context,
//            scope: CoroutineScope
//        ): WishListDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    WishListDatabase::class.java,
//                    "word_database"
//                )
//                    .addCallback(WordDatabaseCallback(scope))
//                    .build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//
//        private class WordDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : RoomDatabase.Callback() {
//            /**
//             * Override the onOpen method to populate the database.
//             * For this sample, we clear the database every time it is created or opened.
//             */
//            override fun onOpen(db: SupportSQLiteDatabase) {
//                super.onOpen(db)
//                // If you want to keep the data through app restarts,
//                // comment out the following line.
//                INSTANCE?.let { database ->
//                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.itemDao())
//                    }
//                }
//            }
//        }
//
//        /**
//         * Populate the database in a new coroutine.
//         * If you want to start with more words, just add them.
//         */
//        suspend fun populateDatabase(itemDao: ItemDao) {
//            // Start the app with a clean database every time.
//            // Not needed if you only populate on creation.
////            itemDao.removeItem()
//
////            var word = itemDao("Hello")
////            itemDao.addItem(word)
////            word = itemDao("World!")
////            itemDao.addItem(word)
//        }
//    }


}