import { signIn, insertData, fetchData } from './lib/supabase'

// Example login function
async function handleLogin(email, password) {
  try {
    const { data, error } = await signIn(email, password)
    if (error) {
      console.error('Login error:', error.message)
      return { success: false, error: error.message }
    }
    console.log('Logged in user:', data.user)
    return { success: true, user: data.user }
  } catch (error) {
    console.error('Unexpected error during login:', error)
    return { success: false, error: 'An unexpected error occurred' }
  }
}

// Example function to insert data (single or batch)
async function handleSubmit(tableName, data) {
  try {
    // Convert single object to array if it's not already an array
    const dataToInsert = Array.isArray(data) ? data : [data]
    
    const { result, error } = await insertData(tableName, dataToInsert)
    if (error) {
      console.error('Insert error:', error.message)
      return { success: false, error: error.message }
    }
    console.log('Data inserted successfully:', result)
    return { success: true, data: result }
  } catch (error) {
    console.error('Unexpected error during insert:', error)
    return { success: false, error: 'An unexpected error occurred' }
  }
}

// Example function to fetch data with filters
async function handleFetch(tableName, query = '*', filters = {}) {
  try {
    let queryBuilder = supabase
      .from(tableName)
      .select(query)

    // Apply filters if provided
    Object.entries(filters).forEach(([key, value]) => {
      if (typeof value === 'object' && value !== null) {
        // Handle range queries (like date ranges)
        Object.entries(value).forEach(([operator, val]) => {
          queryBuilder = queryBuilder.filter(key, operator, val)
        })
      } else {
        // Handle simple equality filters
        queryBuilder = queryBuilder.eq(key, value)
      }
    })

    const { data, error } = await queryBuilder

    if (error) {
      console.error('Fetch error:', error.message)
      return { success: false, error: error.message }
    }
    console.log('Data fetched successfully:', data)
    return { success: true, data }
  } catch (error) {
    console.error('Unexpected error during fetch:', error)
    return { success: false, error: 'An unexpected error occurred' }
  }
}

export { handleLogin, handleSubmit, handleFetch }
