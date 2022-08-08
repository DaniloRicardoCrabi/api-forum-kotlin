package br.com.danilocrabi.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U;
}
