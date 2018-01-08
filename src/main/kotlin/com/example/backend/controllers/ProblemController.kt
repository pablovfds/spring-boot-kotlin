package com.example.backend.controllers

import com.example.backend.models.Problem
import com.example.backend.services.ProblemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/problem")
class ProblemController constructor(private var problemService: ProblemService){

    @GetMapping("")
    fun findAll() = problemService.getAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<Problem> {
        val problem = problemService.getById(id)

        return if (problem == null) ResponseEntity<Problem>(HttpStatus.NOT_FOUND)
        else ResponseEntity<Problem>(problem, HttpStatus.OK)
    }

    @PostMapping("")
    fun createProblem(@RequestBody bodyProblem: Problem) : ResponseEntity<Problem> {
        problemService.create(bodyProblem)
        return ResponseEntity(bodyProblem, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateProblem(@RequestBody body: Problem,
                      @PathVariable id: Long) : ResponseEntity<Problem> {
        val problem = problemService.getById(id)

        return if (problem == null) {
            ResponseEntity<Problem>(HttpStatus.NOT_FOUND)
        } else {
            problem.description = body.description
            problem.name = body.name
            problemService.update(problem)
            ResponseEntity<Problem>(problem, HttpStatus.OK)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProblem(@PathVariable id: Long) : ResponseEntity<Void> {
        val problem = problemService.getById(id)

        return if (problem == null) {
            ResponseEntity<Void>(HttpStatus.NOT_FOUND)
        } else {
            problemService.removeById(id)
            ResponseEntity<Void>(HttpStatus.OK)
        }
    }

}