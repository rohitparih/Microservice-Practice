import React from 'react'
import LandingLeftConfig from '../Configuration/LandingConfig/LandingLeftConfig.json'
import { css, media } from 'glamor';
import SignUp from '../Components/SignUpComp/SignUp';

function Landing() {

  css.global('html, body',  { padding: 0, margin: 0, boxSizing: 'border-box', overflowX: 'hidden' });

  const leftStyle = css(
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
      height: '85vh',
      alignItems: 'center',
      dispaly: 'flex',
      flexDirection: 'column',
      position: 'relative',
    }),
  );

  const logoText = css(
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
      textShadow: "2px 2px 4px rgba(55, 54, 54, 0.2)",
      fontWeight: 800,
      textTransform: 'uppercase',
      fontSize: '6rem',
      color: '#fff',
    }),
    // select(
    //   '& p:first-child', { color: 'red' }
    // ),
    // select(
    //   '& p:last-child', { color: 'blue' }
    // )
  )

  const logoSubText = css(
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
      textShadow: "2px 2px 4px rgba(55, 54, 54, 0.2)",
      fontWeight: 400,
      textTransform: 'uppercase',
      fontSize: '1.6rem',
      color: '#fff',
      opacity: 0.7
    })
  )

  const leftDiv = css(
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
      backgroundColor: '#6a1b9a',
      height: '26rem',
      width: '40rem',
      display: 'flex',
      paddingTop: '4rem',
      justifyContent: 'center',
      alignItems: 'center',
      marginTop: '16%',
      position: 'relative',
      flexDirection: 'column',
      borderTopLeftRadius: '25rem',
      borderTopRightRadius: '25rem',
      borderBottomLeftRadius: '7rem',
      borderBottomRightRadius: '7rem',
      '::after': {
        width: '100px',
        height: '100px',
        backgroundColor: '#6a1b9a',
        position: 'absolute',
        content: ' ',
        right: '10%',
        top: '-7%',
        borderTopLeftRadius: '28rem',
        borderTopRightRadius: '4rem',
        zIndex: -1,
        transform: 'rotate(34deg)'
      },
      '::before': {
        width: '100px',
        height: '100px',
        backgroundColor: '#6a1b9a',
        position: 'absolute',
        content: ' ',
        left: '10%',
        top: '-7%',
        borderTopLeftRadius: '4rem',
        borderTopRightRadius: '28rem',
        zIndex: -1,
        transform: 'rotate(-34deg)'
      }
      // [`& .${subHeading}`]: {

      // }
    })
  )

  return (
    <div className="row">
      <div className="col-lg-6 col-sm-12 col-md-6 col-xs-12 d-flex" {...leftStyle}>
        <div {...leftDiv}>
          <h1 {...logoText}>{LandingLeftConfig.title}</h1>
          <h4 {...logoSubText}>{LandingLeftConfig.subTitle}</h4>
          <h4 {...logoSubText}>{LandingLeftConfig.subTitleDown}</h4>
        </div>
      </div>
      <div className="col-lg-6 col-sm-12 col-md-6 col-xs-12" style={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
      }}>
        <SignUp/>
      </div>
    </div>
  )
}

export default Landing

// effect: style({
//   transition: "all ease .2s",
//   display: 'flex',
//   '@media(max-width: 576px)': { backgroundColor: 'yellow', flexDirection: 'column-reverse'},
// }),

// // Left Container
// left: style({
//   '@media(max-width: 576px)': {

//   },
//   '@media (min-width: 578px) and (max-width: 768px)': { backgroundColor: 'blue' },
//   '@media (min-width: 769px) and (max-width: 992px)': { backgroundColor: 'red' },
//   '@media (min-width: 993px) and (max-width: 1440px)': {
//       height: '85vh', backgroundColor: 'green'
//    }
// }),

// // Right Container
// right: style({
//   '@media(max-width: 576px)': { },
//   '@media (min-width: 578px) and (max-width: 768px)': {  },
//   '@media (min-width: 769px) and (max-width: 992px)': {  },
//   '@media (min-width: 993px) and (max-width: 1440px)': { height: '85vh', backgroundColor: 'red' }
// })