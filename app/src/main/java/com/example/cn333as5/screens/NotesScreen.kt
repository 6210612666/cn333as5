package com.example.cn333as5.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.cn333as5.domain.model.ColorModel
import com.example.cn333as5.domain.model.NoteModel
import com.example.cn333as5.routing.Screen
import com.example.cn333as5.ui.components.Note
import com.example.cn333as5.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun NotesScreen(viewModel: MainViewModel) {
    val notes by viewModel.notesNotInTrash.observeAsState(listOf())
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val searchBy = remember { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Phone book",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
            )
        },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onCreateNewNoteClick() },
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Note Button"
                    )
                }
            )
        }
    ) {

        if (notes.isNotEmpty()) {
            Column(){
                SearchItem(searchBy = searchBy)
                BookList(
                    book = searchBook(searchBy.value,notes),
                    onBookClick = { viewModel.onNoteClick(it) }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
fun searchBook(searchBy:String,bookList : List<NoteModel>):List<NoteModel>{
    val searched : ArrayList<NoteModel> = ArrayList()
    for(aBook in bookList){
        val searchKey = aBook.tag.toString()
        if(searchKey.contains(searchBy,ignoreCase = true)){
            searched.add(aBook)
        }
    }
    return searched.toList()
}

@ExperimentalMaterialApi
@Composable
private fun BookList(
    book: List<NoteModel>,
    onBookClick: (NoteModel) -> Unit
) {
    LazyColumn {
        items(count = book.size) { bookIndex ->
            val aBook = book[bookIndex]
            Note(
                note = aBook,
                onNoteClick = onBookClick,
            )
        }
    }
}


