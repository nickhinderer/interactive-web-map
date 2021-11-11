import React from 'react';
import AboutCard from "./AboutCard";

export default function Person(props) {
    const pic = props.pic;
    const title = props.name;
    const homeTown = props.homeTown;
    const bio = props.bio;

    return (
        <AboutCard pic={pic} title={title} subTitle={homeTown} text={bio} />
    );
}
