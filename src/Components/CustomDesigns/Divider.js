import React from 'react'

const Divider = (props) => {
    return (
        <div style={{
            backgroundColor: props.lineColor ? props.lineColor : '#000',
            width: props.width ? props.width : '100%',
            height: props.boldness ? props.boldness : 1,
            borderRadius: 40,
            marginBottom: props.marginBottom ? props.marginBottom : '7px',
            opacity: props.opacity ? props.opacity : 0.7
        }}></div>
    )
}

export default Divider