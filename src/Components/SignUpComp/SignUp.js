import { css, media } from 'glamor'
import React, { useEffect } from 'react'
import { useState } from 'react'
import SignUpStyle from '../../Style/SignUpStyle/SignUpStyle'
import CustomTextInput from '../CustomDesigns/CustomTextInput'
import Divider from '../CustomDesigns/Divider'
import SignupCompConfig from '../../Configuration/SignupConfig/SignupCompConfig.json'
import { json } from 'react-router-dom'

function SignUp() {

    const signupData = SignupCompConfig.fields;

    document.oncontextmenu = new Function("return false;")
    document.onselectstart = new Function("return false;")

    const [data, setData] = useState({
        name: '',
        email: '',
        username: '',
        password: ''
    })

    const [eventValue, setEventValue] = useState("");

    useEffect(()=> {
        console.log(eventValue)
    }, [data])

    const handleChange = (event, property) => {
        setData({ ...data, [property]: event.target.value });
        setEventValue(event.target.key)
    };


    return (
        <div className="main" {...SignUpStyle.main}>
            <div className="header" {...SignUpStyle.header}>Welcome Bloggios</div>
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                <Divider opacity={0.2} boldness={1.6} width='450px' marginBottom='20px' />
            </div>
            <div className="body" {...SignUpStyle.body}>
                {signupData.map((mapData, key) => {
                    return (
                        <CustomTextInput
                            key={key}
                            backgroundColor={mapData.color}
                            id={mapData.constraint}
                            onChangeData={(e) => handleChange(e, mapData.constraint)}
                            value={mapData.value === data.name ? data.name : mapData.value === data.email ? data.email : mapData.value === data.username ? data.username : data.password}
                            label={mapData.label}
                            placeholder={mapData.placeholder}
                            height='5rem'
                            type={mapData.type}
                            width="100%" />
                    )
                })}
                <div {...SignUpStyle.submitButton} ><p >Submit</p></div>
            </div>
        </div>
    )
}

export default SignUp