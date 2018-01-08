package com.example.backend.services

interface Crud<T> {
    fun create(obj: T): T

    fun getAll(): List<T>

    fun getById(id: Long): T

    fun update(obj: T): T?

    fun removeById(id: Long)

    fun removeAll()
}