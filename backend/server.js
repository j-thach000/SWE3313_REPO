import express from 'express'
import cors from 'cors'
import dotenv from 'dotenv'
import authRoutes from './auth.js'

dotenv.config()

const app = express()

// Middleware
app.use(cors())
app.use(express.json())

// Routes
app.use('/auth', authRoutes)

const PORT = process.env.PORT || 3000

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`)
}) 