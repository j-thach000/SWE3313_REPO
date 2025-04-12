import express from 'express'
import { supabase } from './supabase.js'

const router = express.Router()

// Signup route
router.post('/signup', async (req, res) => {
    try {
        const { email, password } = req.body

        if (!email || !password) {
            return res.status(400).json({ error: "Email and password are required" })
        }

        const { data, error } = await supabase.auth.signUp({
            email: email,
            password: password,
        })

        if (error) throw error

        res.status(201).json({
            message: 'User created successfully',
            user: data.user
        })
    } catch (error) {
        res.status(400).json({ error: error.message })
    }
})
// Login route
router.post('/login', async (req, res) => {
    try {
        const { email, password } = req.body
        
        const { data, error } = await supabase.auth.signInWithPassword({
            email,
            password,
        })

        if (error) throw error

        res.status(200).json({
            message: 'Login successful',
            user: data.user,
            session: data.session
        })
    } catch (error) {
        res.status(400).json({ error: error.message })
    }
})

export default router 