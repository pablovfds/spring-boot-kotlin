package com.example.backend.services

import com.example.backend.models.Problem
import com.example.backend.repositories.ProblemRepository
import org.springframework.stereotype.Service

@Service
class ProblemService
    constructor(private var problemRepository: ProblemRepository): Crud<Problem>{

    override fun create(obj: Problem) = problemRepository.save(obj)

    override fun getAll() = problemRepository.findAll().toList()

    override fun getById(id: Long) = problemRepository.findOne(id)

    override fun update(obj: Problem): Problem? {
        return if (problemRepository.exists(obj.id)) problemRepository.save(obj) else null
    }

    override fun removeById(id: Long) = problemRepository.delete(id)

    override fun removeAll() = problemRepository.deleteAll()
}