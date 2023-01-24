import { css, hover, media } from "glamor";

const SignUpStyle = {

    // Component Design
    main: css(
        media('(max-width: 576px)', {
            backgroundColor: 'red'
        }),
        media('(min-width: 578px) and (max-width: 768px)', {
            backgroundColor: 'green'
        }),
        media('(min-width: 769px) and (max-width: 992px)', {
            backgroundColor: 'blue'
        }),
        media('(min-width: 993px) ', {
            fontFamily: "'Inter', sans-serif",
            marginTop: '1.6rem',
            border: '2px solid rgba(0, 0, 0, 0.2)',
            height: 'auto',
            width: '500px',
            dispaly: 'flex',
            paddingBottom: '0.8rem',
            flexDirection: 'column',
            position: 'relative',
            backgroundColor: 'white',
            borderTopRadius: '10px',
            borderRadius: '20px',
            boxShadow: '1px 1px 2px rgba(0, 0, 0, 0.2)',
            userSelect: 'none',
        }),
    ),

    // Component Header
    header: css(
        media('(max-width: 576px)', {
            backgroundColor: 'red'
        }),
        media('(min-width: 578px) and (max-width: 768px)', {
            backgroundColor: 'green'
        }),
        media('(min-width: 769px) and (max-width: 992px)', {
            backgroundColor: 'blue'
        }),
        media('(min-width: 993px) ', {
            fontFamily: "'Inter', sans-serif",
            fontSize: '2rem',
            textAlign: 'center',
            marginTop: '25px',
            marginBottom: '20px',
            userSelect: 'none',
        }),
    ),

    // Body
    body: css(
        media('(max-width: 576px)', {
            backgroundColor: 'red'
        }),
        media('(min-width: 578px) and (max-width: 768px)', {
            backgroundColor: 'green'
        }),
        media('(min-width: 769px) and (max-width: 992px)', {
            backgroundColor: 'blue'
        }),
        media('(min-width: 993px) ', {
            fontFamily: "'Inter', sans-serif",
            dispaly: 'flex',
            flexDirection: 'column',
            padding: '20px 25px',
            marginBottom: '10px',
            userSelect: 'none',
        }),
    ),

    submitButton: css(
        media('(max-width: 576px)', {
            backgroundColor: 'red'
        }),
        media('(min-width: 578px) and (max-width: 768px)', {
            backgroundColor: 'green'
        }),
        media('(min-width: 769px) and (max-width: 992px)', {
            backgroundColor: 'blue'
        }),
        media('(min-width: 993px) ', {
            fontFamily: "'Inter', sans-serif",
            height: '4rem',
            width: '450px',
            backgroundColor: '#6a1b9a',
            borderRadius: '16px',
            boxShadow: 'none',
            color: '#fff',
            fontWeight: 700,
            paddingTop: '16px',
            fontSize: '1.6rem',
            textTransform: 'uppercase',
            transition: 'background-color 0.1s ease-in, color 0.1s ease-in',
            display: 'flex',
            justifyContent: 'center',
            letterSpacing: '0.2rem',
            alignItems: 'center',
            marginTop: '2.8rem',
            userSelect: 'none',
            ':hover': ({
                boxShadow: '1px 1px 4px rgba(0, 0, 0, 0.7)',
                backgroundColor: '#fff',
                borderColor: '#6a1b9a',
                borderWidth: '3px',
                borderStyle: 'solid',
                color: '#6a1b9a'
            }),
            ':active': ({
                boxShadow: 'none'
            })
        }),
    )
}

export default SignUpStyle;