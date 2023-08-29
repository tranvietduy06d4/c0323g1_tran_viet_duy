import axios from "axios";


export default function List({ covids }) {

    return (
        <>
            <h1>Vietnam's Covid-19 infomation</h1>
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Confirmed</th>
                        <th>Active</th>
                        <th>Recovered</th>
                        <th>Deaths</th>
                    </tr>
                </thead>
                <tbody>
                    {covids.map((info) => {
                        return (
                            <tr key={info.id}>
                                <td>{info.date}</td>
                                <td>{info.confirmed}</td>
                                <td>{info.active}</td>
                                <td>{info.recovered}</td>
                                <td>{info.deaths}</td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </>
    )
}

export async function getStaticProps() {
    const result = await axios.get("http://localhost:8080/covid");
    const covids = result.data;
    return {
        props: {
            covids
        }
    }
}