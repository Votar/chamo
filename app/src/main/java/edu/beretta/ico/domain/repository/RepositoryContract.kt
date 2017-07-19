package edu.beretta.ico.domain.repository


interface RepositoryContract<T : Object> {

    abstract fun insert(model: T)

    abstract fun update(model: T)

    abstract fun getmodelById(id: Long): T

    abstract fun getAllmodels(): List<T>

    abstract fun delete(model: T)

}