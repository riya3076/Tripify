import React from 'react'

const Error = () => {

    const errorStyle = { 
        fontSize: '40px',
        color: '#333',
        marginBottom: '20px',
        fontWeight: 'bold',
        fontFamily: 'Arial, sans-serif',
        textShadow: '2px 2px 4px rgba(0, 0, 0, 0.3)', 
        letterSpacing: '1px',
        
      };
      
    
  return (
    <div style={errorStyle}>
      <h1>Page not found! 404!  </h1>
    </div>
  )
}

export default Error
