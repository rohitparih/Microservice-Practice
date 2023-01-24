import { css, focus, hover } from 'glamor'
import React, { useRef, useState } from 'react'
import dummy from '../../Style/dummy.css'

const CustomTextInput = (props) => {

    const focusInput = focus(
        {
            outline: 'none',
        }
    )

    const textInput = useRef(null);

    const handleClick = () => {
        textInput.current.focus();
    }

    const [focused, setFocused] = useState(false);
    const [border, setBorder] = useState('#000')

    const onFocus = () => setFocused(true);
    const onBlur = () => setFocused(false);


    return (
        <div onClick={() => handleClick()} style={{
            marginBottom: '1rem',
            width: props.width ? props.width : '100%',
            height: props.height ? props.height : 'auto',
            backgroundColor: props.backgroundColor ? props.backgroundColor : '#fff',
            color: props.color ? props.color : '#212121',
            borderRadius: props.borderRadius ? '#ede7f6' : '10px',
            boxShadow: '1px 1px 2px rgba(0, 0, 0, 0.2)',
            position: 'relative',
            display: 'flex',
            flexDirection: 'column',
            borderColor: focused ? '#6a1b9a' : "#0000",
            borderWidth: '2px',
            borderStyle: 'solid',
        }}>
            <p style={{
                fontFamily: "'Inter', sans-serif",
                paddingLeft: '1rem',
                marginTop: '0.6rem',
                fontSize: '1rem',
                fontWeight: 500,
                letterSpacing: '1px'
            }}>{props.label}</p>
            <input {...focusInput}
                onFocus={onFocus}
                onBlur={onBlur}
                ref={textInput}
                style={{
                    border: 'none',
                    backgroundColor: props.backgroundColor ? props.backgroundColor : '#fff',
                    marginLeft: '2.8%',
                    width: '95%',
                    marginTop: '-0.9rem',
                    caretColor: props.caretColor,
                    fontWeight: props.fontWeight ? props.fontWeight : 500,
                    letterSpacing: '1px',
                    height: '2rem',
                    fontSize: '1rem',
                    color: props.color ? props.color : '#000',
                    opacity: props.opacity ? props.opacity : 0.7
                }}
                type={props.type ? props.type : 'text'}
                onChange={props.onChangeData}
                value={props.valueData}
                id={props.id}
                placeholder={props.placeholder} />
        </div>
    )
}

export default CustomTextInput